package com.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.DAO.Groups;
import com.school.repository.GroupsRepository;

@Service
public class GroupsService {

	@Autowired
	private GroupsRepository groupsRepository;

	public Optional<Groups> getGroupsById(int id) {
		return groupsRepository.findById(id);
	}

	public List<Groups> getAllGroups(){
		return  (List<Groups>) groupsRepository.findAll();
	}

	public void addGroups(Groups groups) {
		groupsRepository.save(groups);
	}
	public void updateGroups(int id, String name) {
		Optional<Groups> group = groupsRepository.findById(id);
		if(group.isPresent()) {
			Groups g = group.get();
			g.setName(name);
			groupsRepository.save(g);
		}
	}
	public void deleteGroup(int id) {
		groupsRepository.deleteById(id);
	}
}
