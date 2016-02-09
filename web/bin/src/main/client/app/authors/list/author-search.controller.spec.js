describe('book controller', function () {
    'use strict';

    beforeEach(function () {
        module('app.authors');
    });
 
    var $scope,controller,$authorService,$Flash;
    
    beforeEach(inject(function ($httpBackend,$rootScope,$controller, authorService, Flash) {
        $httpBackend.whenGET('/context.html/services/authors/allAuthors').respond('');
        $scope = $rootScope.$new();
        $authorService = authorService;
        $Flash = Flash;
        controller = $controller('AuthorSearchController', {$scope: $scope});
    }));

    it('search is defined', inject(function ($controller) {
        // when
        $controller('AuthorSearchController', {$scope: $scope});
        // then
        expect($scope.search).toBeDefined();
    }));

    it('search should call authorService.search', inject(function ($httpBackend, $controller, $q, authorService, Flash) {
    	// given
    	var result = {'data':[{ 'id':1, 'firstName':'First', 'lastName':'Last'}]};
    	var searchDeferred = $q.defer();
    	spyOn(authorService, 'search').and.returnValue(searchDeferred.promise);
    	// when
    	$scope.search();
    	searchDeferred.resolve(result);
    	$scope.$digest();
    	// then
    	expect(authorService.search).toHaveBeenCalledWith();
    }));
});
