describe('book controller', function () {
    'use strict';

    beforeEach(function () {
        module('app.books');
    });

    var $scope,controller,$bookService,$Flash;
    
    beforeEach(inject(function ($rootScope,$controller, bookService, Flash) {
        $scope = $rootScope.$new();
        $bookService = bookService;
        $Flash = Flash;
        controller = $controller('BookSearchController', {$scope: $scope});
    }));

    it('search is defined', inject(function ($controller) {
        expect($scope.search).toBeDefined();
    }));
    
    it('deleteBook is defined', inject(function ($controller) {
    	expect($scope.deleteBook).toBeDefined();
    }));
    
    it('addBook is defined', inject(function ($controller) {
    	expect($scope.addBook).toBeDefined();
    }));
    
    it('editBook is defined', inject(function ($controller) {
    	expect($scope.editBook).toBeDefined();
    }));
    
    it('delete book should call bookService.deleteBook', inject(function ($controller, $q, bookService, Flash) {
        // given
        var bookId = 1;
        $scope.books = [{id: bookId, title: 'test'}];
        var deleteDeferred = $q.defer();
        spyOn(bookService, 'deleteBook').and.returnValue(deleteDeferred.promise);
        spyOn(Flash, 'create');
        // when
        $scope.deleteBook(bookId);
        deleteDeferred.resolve();
        $scope.$digest();
        // then
        expect(bookService.deleteBook).toHaveBeenCalledWith(bookId);
        expect(Flash.create).toHaveBeenCalledWith('success', 'Książka została usunięta.', 'custom-class');
        expect($scope.books.length).toBe(0);
    }));
    
    it('search should call bookService.search', inject(function ($controller, $q, bookService, Flash) {
    	// given
    	var result = {'data':[{'id':1,'title':'Pierwsza książka', 'authors':[{ 'id':1, 'firstName':'First', 'lastName':'Last'}]}]};
    	var titlePrefix = 'druga';
    	var searchDeferred = $q.defer();
    	spyOn($bookService, 'search').and.returnValue(searchDeferred.promise);
    	// when
    	$scope.prefix = titlePrefix;
    	searchDeferred.resolve(result);
    	$scope.search();
    	$scope.$digest();
    	// then
    	expect($bookService.search).toHaveBeenCalledWith(titlePrefix);
    }));
    
    it('search should fail to call bookService.search', inject(function ($controller, $q, bookService, Flash) {
    	// given
    	var searchDeferred = $q.defer();
    	spyOn($bookService, 'search').and.returnValue(searchDeferred.promise);
    	spyOn(Flash, 'create');
    	// when
    	searchDeferred.reject();
    	$scope.search();
    	$scope.$digest();
    	// then
    	expect($bookService.search).toHaveBeenCalled();
        expect($Flash.create).toHaveBeenCalledWith('danger', 'Wyjątek', 'custom-class');
    }));

});
