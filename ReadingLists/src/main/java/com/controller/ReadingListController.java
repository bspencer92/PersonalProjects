package com.controller;

import com.readinglists.com.Entity.ReadingList;
import com.readinglists.com.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ReadingListController {
    @Autowired
    ReadingListRepository readingListRepository;

    @RequestMapping(value = "/findReadingListById", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<Optional<ReadingList>> findReadingList(Integer id) {
        Optional<ReadingList> readingList = readingListRepository.findById(id);
        return new ResponseEntity<>(readingList, HttpStatus.OK); }

    @RequestMapping(value = "/findReadingLists", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    private ResponseEntity<List<ReadingList>> findReadingLists(ReadingList readingList) {
        List<ReadingList> readingLists = readingListRepository.findAll();
        return new ResponseEntity<>(readingLists, HttpStatus.OK);

    }

}
