angular.module('app.authors', ['ngRoute', 'app.main', 'ui.bootstrap', 'flash']).config(function ($routeProvider) {
    'use strict';

    $routeProvider.when('/authors/author-list', {
        templateUrl: 'authors/list/author-list.html',
        controller: 'AuthorSearchController'
    });
});