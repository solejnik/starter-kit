angular.module('app.books').controller(
		'AuthorModalController',
		function($scope, bookService, Flash, $modal, $modalInstance,$window) {
			'use strict';
			$scope.authorFirstName = '';
			$scope.authorLastName = '';
			$scope.author = {
				firstName : '',
				lastName : ''
			};

			$scope.closeMyModal = function() {
				$modalInstance.close($scope.author);
			};
		});
