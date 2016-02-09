angular.module('app.books').controller('BookSearchController', function ($scope, $window, $location, bookService, Flash, $modal) {
    'use strict';

    $scope.books = [];
    $scope.prefix = '';
    $scope.bookTitle = '';
    $scope.gridOptions = { data: 'books' };

    var removeBookById = function (bookId) {
        for (var i = 0; i < $scope.books.length; i = i + 1) {
            if ($scope.books[i].id === bookId) {
                $scope.books.splice(i, 1);
                break;
            }
        }
    };

    $scope.search = function () {
        bookService.search($scope.prefix).then(function (response) {
            angular.copy(response.data, $scope.books);
        }, function () {
            Flash.create('danger', 'Wyjątek', 'custom-class');
        });
    };

    $scope.deleteBook = function (bookId) {
        bookService.deleteBook(bookId).then(function () {
            removeBookById(bookId);
            Flash.create('success', 'Książka została usunięta.', 'custom-class');
        });
    };

    $scope.addBook = function () {
        var modalInstance = $modal.open({
            templateUrl: 'books/add/add-book-modal.html',
            controller: 'BookModalController',
            size: 'lg'
        });
        modalInstance.result.then(function(book){
             $scope.books.push(book);
       });
    };
    
    $scope.editBook = function (book) {
        var modalInstance = $modal.open({
            templateUrl: 'books/edit/edit-book-modal.html',
            controller: 'EditBookModalController',
            size: 'lg',
            resolve: {
                book: function () {
                  return book;
                }
              }
        });
        modalInstance.result.then(function(){
        });
    };

});
