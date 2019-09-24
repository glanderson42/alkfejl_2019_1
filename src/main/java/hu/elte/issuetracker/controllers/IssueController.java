package hu.elte.issuetracker.controllers;

import hu.elte.issuetracker.entities.Issue;
import hu.elte.issuetracker.repositories.IssueRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("issues")
public class IssueController {
    @Autowired
    private IssueRepository issueRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Issue>> getAll() {
        return ResponseEntity.ok(issueRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Issue> get(@PathVariable Integer id) {
        Optional<Issue> issue = issueRepository.findById(id);
        if(!issue.isPresent()) {
            ResponseEntity.notFound();
        }

        return ResponseEntity.ok(issue.get());
    }

    @PostMapping("")
    public ResponseEntity<Issue> post(@RequestBody Issue issue) {
        Issue newIssue = issueRepository.save(issue);
        return ResponseEntity.ok(newIssue);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Issue> issue = issueRepository.findById(id);
        if(!issue.isPresent()) {
            ResponseEntity.notFound();
        }

        issueRepository.delete(issue.get());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Issue> put(@PathVariable Integer id, @RequestBody Issue issue) {
        Optional<Issue> oldIssue = issueRepository.findById(id);
        if(!oldIssue.isPresent()) {
            ResponseEntity.notFound();
        }

        issue.setId(id);
        return ResponseEntity.ok(issueRepository.save(issue));
    } 
}