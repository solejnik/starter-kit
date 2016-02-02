angular.module('app.books').controller('AuthorModalController', function ($scope, bookService, Flash, $modal,$modalInstance) {
    'use strict';
    $scope.authorFirstName = '';
    $scope.authorLastName = '';
    $scope.author = {
    		firstName:'',lastName:''
    }
    
    
    $scope.closeMyPopup = function () {
        $modalInstance.close($scope.author);
      };
});
