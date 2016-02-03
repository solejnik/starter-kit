angular.module('app.books').controller('EditBookModalController', function ($scope, bookService, Flash, $modal,book, $modalInstance) {
    'use strict';
    $scope.book = book;
    $scope.title = $scope.book.title;
    $scope.oldTitle = $scope.book.title;

    $scope.updateTitle = function () {
        $scope.book.title = $scope.title;
        bookService.updateBook($scope.book).then(function () {
            $modalInstance.close();
            Flash.create('success', 'Książka została zaktualizowana.', 'custom-class');
        },function () {
            $scope.book.title = $scope.oldTitle;
            Flash.create('danger', 'Książka nie została zaktualizowana.', 'custom-class');
        });
    };
});
