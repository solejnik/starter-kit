angular.module('app.books').controller(
		'AuthorModalController',
		function($scope, bookService, Flash, $modal, $modalInstance) {
			'use strict';
			$scope.authorFirstName = '';
			$scope.authorLastName = '';
			$scope.author = {
				firstName : '',
				lastName : ''
			};

			$scope.valid = function() {
				if ((jQuery('#aFname').val() == '')
						|| (jQuery('#aLname').val() == '')) {
					return true;
				} else {
					return false;
				}
			};
			$scope.closeMyModal = function() {
				$modalInstance.close($scope.author);
			};
		});
