angular.module('app.books').controller('EditBookModalController', function ($scope, bookService, Flash, $modal,book, $modalInstance) {
    'use strict';
    $scope.book = book;
    $scope.title = $scope.book.title;
    	
    $scope.updateTitle = function () {
    	$scope.book.title = $scope.title;
    	bookService.addBook($scope.book);
    }

});
