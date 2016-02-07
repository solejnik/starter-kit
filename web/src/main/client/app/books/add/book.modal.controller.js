angular.module('app.books').controller('BookModalController', function ($scope,bookRestService, bookService, Flash, $modal, $modalInstance,$window) {
    'use strict';
    $scope.authorFirstName = '';
    $scope.authorLastName = '';
    $scope.bookTo =  {
             'title':'','authors':[]		 
                  };
    $scope.addBook = function () {
         bookService.addBook($scope.bookTo).then(function (response) {
             $modalInstance.close(response.data);
             Flash.create('success', 'Książka została dodana.', 'custom-class');
         }, function () {
             Flash.create('danger', 'Wyjątek', 'custom-class');
         });
    };
    
    $scope.addAuthors = function () {
        var modalInstance = $modal.open({
            templateUrl: 'books/add/add-authors-modal.html',
            controller: 'AuthorModalController',
            size: 'lg'
        });
        
        modalInstance.result.then(function(author){
            $scope.bookTo.authors.push(author);
       });
        $window.jQuery();
    };


});
