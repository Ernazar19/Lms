import classes.Group;
import classes.Lessons;
import classes.Student;

import sercices.serviceImpl.ServicesImpl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Group> groups1 = new ArrayList<>();
        ServicesImpl services = new ServicesImpl();
        List<Student> students = new ArrayList<>();
        List<Lessons> lessons = new ArrayList<>();
        try {
            while (true) {
                System.out.println("""
                         |--------------------------------------|
                         |<~~~~~~~~~~Выберите команду~~~~~~~~~~>|
                         |______________________________________|
                         | 1  -> Add new group                  |
                         | 2  -> Get group by name              |
                         | 3  -> Update group name              |
                         | 4  -> Get all groups                 |
                         | 5  -> Add new student to group       |
                         | 6  -> Update student                 | 
                         | 7  -> Find student by first name     | 
                         | 8  -> Get all students by group name |
                         | 9  -> Get all student's lesson       |
                         | 10 -> Delete student                 |
                         | 11 -> Add new lesson to group        |
                         | 12 -> Get lesson by name             |
                         | 13 -> Get all lesson by group name   |
                         | 14 -> Delete lesson                  |
                         | 15 -> Delete group                   |
                         |______________________________________|
                        """);
                int number = scanner.nextInt();
                switch (number) {
                    case 1:
                        services.addNewGroup(groups1);
                        break;
                    case 2:
                        services.getGroupByName(groups1);
                        break;
                    case 3:
                        services.updateGroupName(groups1);
                        break;
                    case 4:
                        services.getAllGroups(groups1);
                        break;
                    case 5:
                        services.addNewStudentToGroup(groups1);
                        break;
                    case 6:
                        services.updateStudent(groups1);
                        break;
                    case 7:
                        services.findStudentByFirstName(groups1);
                        break;
                    case 8:
                        services.getAllStudentsByGroupName(groups1);
                        break;
                    case 9:
                        services.getAllStudentsLesson(groups1);
                        break;
                    case 10:
                        services.deleteStudent(students);
                        break;
                    case 11:
                        services.addNewLessonToGroup(groups1);
                        break;
                    case 12:
                        services.getLessonByName(groups1);
                        break;
                    case 13:
                        services.getAllLessonByGroupName(groups1);
                        break;
                    case 14:
                        services.deleteLesson(lessons);

                        break;
                    case 15:
                        services.deleteGroup(groups1);
                        break;
                    default:
                        System.out.println("Больше 15-команд нет!");
                }
            }
        } catch (InputMismatchException a) {
            System.out.println("Введите только цифры от 1-15");
        }
    }
}