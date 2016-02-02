angular.module('app.books').controller('EditBookModalController', function ($scope, bookService, Flash, $modal,bookTitle, bookId) {
    'use strict';
    $scope.title = bookTitle;
    $scope.id = bookId;
});
