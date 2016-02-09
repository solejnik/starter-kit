describe('edit book modal controller', function () {
    'use strict';

    beforeEach(function () {
        module('app.books');
    });

    var $scope, modalInstance,controller;
    
    beforeEach(inject(function ($rootScope, $controller, bookService) {
        $scope = $rootScope.$new();
        modalInstance = {
            close : jasmine.createSpy('modalInstance.close'), dismiss : jasmine.createSpy('modalInstance.dismiss'),
            result : {
                then : jasmine.createSpy('modalInstance.result.then')
            }
        };
        var someBook = {title:'123'};
        controller = $controller('EditBookModalController', {
            $scope : $scope, $modalInstance : modalInstance, bookService : bookService, book : someBook
        });
    }));

    it('updateTitle should call bookService updateBook', inject(function($q, bookService) {
        // given
        $scope.$close = jasmine.createSpy('$close');
        var addDeferred = $q.defer();
        var result = {title:'123'};
        spyOn(bookService, 'updateBook').and.returnValue(addDeferred.promise);
        // when
        $scope.updateTitle();
        $scope.$digest();
        // then
        expect(bookService.updateBook).toHaveBeenCalledWith(result);
    }));

    
});