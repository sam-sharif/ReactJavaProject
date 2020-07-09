package telus.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import telus.server.entity.Project;

@Repository
public interface ProjectDAO extends JpaRepository<Project,Long>{

	public Project findByProjectIdentifier(String projectId);
}
