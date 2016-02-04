describe('book service', function () {
    'use strict';

    beforeEach(function () {
        module('app.books');
    });

    var $bookService,$bookRestService;
    
    beforeEach(inject(function(bookService, bookRestService) {
        $bookService = bookService;
        $bookRestService = bookRestService;
    }));

    it('search is defined', inject(function () {
        //then
        expect($bookService.search).toBeDefined();
    }));
    
    it('deleteBook is defined', inject(function () {
        //then
        expect($bookService.deleteBook).toBeDefined();
    }));
    
    it('addBook is defined', inject(function () {
        //then
        expect($bookService.addBook).toBeDefined();
    }));
    
    it('deleteBook should call bookRestService.deleteBook', inject(function () {
        //given
        var testBookId = 1;
        spyOn($bookRestService, 'deleteBook');
        //when
        $bookService.deleteBook(testBookId);
        //then
        expect($bookRestService.deleteBook).toHaveBeenCalledWith(testBookId);
    }));
    
    it('addBook should call bookRestService.addBook', inject(function () {
        //given
        var testBook = {};
        spyOn($bookRestService, 'addBook');
        //when
        $bookService.addBook(testBook);
        //then
        expect($bookRestService.addBook).toHaveBeenCalledWith(testBook);
    }));
    
    it('editBook should call bookRestService.updateBook', inject(function () {
    	//given
    	var testBook = {};
    	spyOn($bookRestService, 'updateBook');
    	//when
    	$bookService.updateBook(testBook);
    	//then
    	expect($bookRestService.updateBook).toHaveBeenCalledWith(testBook);
    }));
    
    it('search should call bookRestService.search', inject(function () {
    	//given
    	var titlePrefix = '';
    	spyOn($bookRestService, 'search');
    	//when
    	$bookService.search(titlePrefix);
    	//then
    	expect($bookRestService.search).toHaveBeenCalledWith(titlePrefix);
    }));

});
