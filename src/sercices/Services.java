package sercices;

/*
Datka Mamatzhanova(Java mentor)
        5 д. назад
        *** Бир команда танданыз! ***
       void addNewGroup();
       void getGroupByName();
       void updateGroupName();
       void getAllGroups();
       void addNewStudentToGroup();
       void updateStudent();
       void findStudentByFirstName();
       void getAllStudentsByGroupName();
       void getAllStudent'sLesson();
       void deleteStudent();
       void addNewLessonToGroup();
       void getLessonByName();
       void getAllLessonByGroupName();
       void deleteLesson();
       void deleteGroup();
*/

import classes.Group;
import classes.Lessons;
import classes.Student;

import java.util.List;

public interface Services {
   Group addNewGroup(List<Group>groups);
    void getGroupByName(List<Group>groups);
    Group updateGroupName(List<Group>groups);
    void getAllGroups(List<Group>groups);
    List<Student> addNewStudentToGroup(List<Group>groups);
    List<Student> updateStudent(List<Group>groups);
    void findStudentByFirstName(List<Group>groups);
    void getAllStudentsByGroupName(List<Group>groups);
    void getAllStudentsLesson(List<Group>groups);
    void deleteStudent(List<Student>groups);
   Lessons addNewLessonToGroup(List<Group>groups);
    void getLessonByName(List<Group>groups);
    void getAllLessonByGroupName(List<Group>groups);
    void deleteLesson(List<Lessons>lessons);
    void deleteGroup(List<Group>groups);


}
