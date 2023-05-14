package com.iftm.exercicio02.controllers;

import com.iftm.exercicio02.data.vo.UserVO;
import com.iftm.exercicio02.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@Api(value = "User Endpoint", tags = {"User"})
public class UserController {

    @Autowired
    private UserService service;

    // READ - HTTP GET
    // Endpoint: http://localhost:8080/api/v1/user
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Find all Users", notes = "Return a list with all Users")
    public List<UserVO> findAll() {
        return service.findAll();
    }

    // READ - HTTP GET
    // Endpoint: http://localhost:8080/api/v1/user/ID
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Find a User by ID", notes = "Return a User by ID")
    public UserVO findById(
            @ApiParam(value = "User ID", required = true)
            @PathVariable("id") Long id) {
        return service.findById(id);
    }

    // USERS BY GROUP NAME - HTTP GET
    // Endpoint: http://localhost:8080/api/v1/user/group/NOME_DO_GRUPO
    @GetMapping(value = "/group/{name}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Find Users by Group Name", notes = "Return a list of Users by Group Name")
    public List<UserVO> findUsersByGroupName(
            @ApiParam(value = "Group Name", required = true)
            @PathVariable("name") String groupName) {
        return service.findByGroupName(groupName);
    }

    // CREATE - HTTP POST
    // Endpoint: http://localhost:8080/api/v1/user
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Create a new User", notes = "Return a new User")
    public UserVO save(
            @ApiParam(value = "User object", required = true)
            @RequestBody UserVO userVO) {
        return service.save(userVO);
    }

    // UPDATE - HTTP PUT
    // Endpoint: http://localhost:8080/api/v1/user
    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Update a User", notes = "Return the updated User")
    public UserVO update(
            @ApiParam(value = "User object", required = true)
            @RequestBody UserVO userVO) {
        return service.update(userVO);
    }

    // DELETE - HTTP DELETE
    // Endpoint: http://localhost:8080/api/v1/user/ID
    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Delete a User by ID", notes = "Return a message")

    public ResponseEntity<String> delete(
            @ApiParam(value = "User ID", required = true)
            @PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok("User with ID " + id + " deleted successfully.");
    }
}