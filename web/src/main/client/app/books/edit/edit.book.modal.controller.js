angular.module('app.books').controller('EditBookModalController', function ($scope, bookService, Flash, $modal,bookTitle) {
    'use strict';
    $scope.title = bookTitle;
});
