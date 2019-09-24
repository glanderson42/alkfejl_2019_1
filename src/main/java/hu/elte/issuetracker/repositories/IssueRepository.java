package hu.elte.issuetracker.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.elte.issuetracker.entities.Issue;

@Repository
public interface IssueRepository extends CrudRepository<Issue, Integer> {

}