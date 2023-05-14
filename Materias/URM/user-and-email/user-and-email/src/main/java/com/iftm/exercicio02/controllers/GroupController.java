package com.iftm.exercicio02.controllers;

import com.iftm.exercicio02.data.vo.GroupVO;
import com.iftm.exercicio02.services.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/group")
@Api(value = "Group Endpoint", tags = {"Group Endpoint"})
public class GroupController {

    @Autowired
    GroupService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Find all Groups", notes = "Find all Groups recorded in the database")
    public CollectionModel<EntityModel<GroupVO>> findAll() {
        List<EntityModel<GroupVO>> groups = service.findAll().stream()
                .map(group -> EntityModel.of(group,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GroupController.class)
                                .findById(group.getId())).withSelfRel(),
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GroupController.class)
                                .insertUsers(group)).withRel("insert-users")))
                .collect(Collectors.toList());

        return CollectionModel.of(groups, WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GroupController.class)
                .findAll()).withSelfRel());
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Find Group by ID", notes = "Find a specific Group by its ID")
    public EntityModel<GroupVO> findById(@PathVariable("id") Long id) {
        GroupVO group = service.findById(id);

        return EntityModel.of(group,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GroupController.class)
                        .findById(group.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GroupController.class)
                        .insertUsers(group)).withRel("insert-users"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GroupController.class)
                        .findAll()).withRel("all-groups"));
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Create Group", notes = "Create a new Group")
    public EntityModel<GroupVO> save(@RequestBody GroupVO groupVO) {
        GroupVO group = service.save(groupVO);

        return EntityModel.of(group,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GroupController.class)
                        .findById(group.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GroupController.class)
                        .insertUsers(group)).withRel("insert-users"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GroupController.class)
                        .findAll()).withRel("all-groups"));
    }

    @PostMapping(value = "insert-users", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Insert Users into Group", notes = "Insert one or more users into a specific Group")
    public EntityModel<GroupVO> insertUsers(@RequestBody GroupVO groupVO) {
        GroupVO group = service.insertUsers(groupVO);

        return EntityModel.of(group,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GroupController.class)
                        .findById(group.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GroupController.class)
                        .insertUsers(group)).withRel("insert-users"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GroupController.class)
                        .findAll()).withRel("all-groups"));
    }


    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "Update Group", notes = "Update an existing Group")
    public EntityModel<GroupVO> update(@RequestBody GroupVO groupVO) {
        GroupVO group = service.update(groupVO);

        return EntityModel.of(group,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GroupController.class)
                        .findById(group.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GroupController.class)
                        .insertUsers(group)).withRel("insert-users"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(GroupController.class)
                        .findAll()).withRel("all-groups"));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Group", notes = "Delete an existing Group")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}