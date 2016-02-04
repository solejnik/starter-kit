describe('book modal controller', function () {
    'use strict';

    beforeEach(function () {
        module('app.books');
    });

    var $scope;
    var modalInstance;
    var controller;
    
    beforeEach(inject(function ($rootScope, $controller, bookService) {
        $scope = $rootScope.$new();
        modalInstance = {
            close : jasmine.createSpy('modalInstance.close'), dismiss : jasmine.createSpy('modalInstance.dismiss'),
            result : {
                then : jasmine.createSpy('modalInstance.result.then')
            }
        };

        controller = $controller('BookModalController', {
            $scope : $scope, $modalInstance : modalInstance, bookService : bookService
        });
    }));

    it('addBook should call bookService addBook', inject(function($q, bookService) {
        // given
        $scope.$close = jasmine.createSpy('$close');
        var addDeferred = $q.defer();
        var result = {title : '', 'authors': [] };
        spyOn(bookService, 'addBook').and.returnValue(addDeferred.promise);
        // when
        $scope.addBook();
        $scope.$digest();
        // then
        expect(bookService.addBook).toHaveBeenCalledWith(result);
    }));

    
});