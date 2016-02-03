angular.module('app.books').factory('bookRestService', function ($http, currentContextPath) {
    'use strict';

    return {
        search: function (titlePrefix) {
            return $http.get(currentContextPath.get() + 'services/books/books-by-title', {params: {titlePrefix: titlePrefix}});
        },
        deleteBook: function (bookId) {
            return $http.delete(currentContextPath.get() + 'services/books/book/' + bookId);
        },
        addBook: function (bookTo) {
            return $http.post(currentContextPath.get() + 'services/books/book/', bookTo);
        },
        updateBook: function (bookTo) {
        	return $http.put(currentContextPath.get() + 'services/books/book/', bookTo);
        }
    };
});
