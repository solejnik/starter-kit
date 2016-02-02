angular.module('app.books').controller('BookModalController', function ($scope, bookService, Flash, $modal) {
    'use strict';
    $scope.authorFirstName = '';
    $scope.authorLastName = '';
    $scope.bookTo =  {
			 "title":"","authors":[]		 
	 				}	
    $scope.addBook = function () {
//    	 var bookTo = 
//    	 {
//    			 "title":$scope.title,"authors":[{"firstName":$scope.authors.split(" ")[0],"lastName":$scope.authors.split(" ")[1]}]		 
//    	 }
         bookService.addBook($scope.bookTo).then(function (response) {
             angular.copy(response.data, $scope.books);
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
        
    };

});
