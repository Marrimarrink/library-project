package ru.itgirl.library_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itgirl.library_project.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}