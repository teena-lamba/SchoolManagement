package com.school.component;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.DAO.Groups;
import com.school.service.GroupsService;
import com.school.service.SchoolService;

@RestController
public class GroupsController {

	@Autowired
	private GroupsService groupsService;

	@GetMapping(value = "/groups/{id}")
	public Groups getGroupsById(@PathVariable("id") int id) {
		return groupsService.getGroupsById(id).get();
	}
	@GetMapping(value = "/groups/all")
	public List<Groups> getAllGroups(){
		return groupsService.getAllGroups();
	}
	@PostMapping(value = "/groups/add")
	public void addGroups(@RequestBody Groups groups) {
		groupsService.addGroups(groups);
	}

	@PutMapping(value = "/update/groups/{name}")
	public void updateGroups(@PathVariable("name") String name) {
		//groupsRepository.
	}
	@DeleteMapping(value = "/groups/{id}/delete")
	public void deleteById(@PathVariable("id") int id) {
		groupsService.deleteGroup(id);
	}

}
