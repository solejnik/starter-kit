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

			$scope.valid = function() {
				if (($window.jQuery('#aFname').val() == '')
						|| ($window.jQuery('#aLname').val() == '')) {
					return true;
				} else {
					return false;
				}
			};
			$scope.closeMyModal = function() {
				$modalInstance.close($scope.author);
			};
		});
