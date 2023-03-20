package sercices.serviceImpl;

import classes.Group;
import classes.Lessons;
import classes.Student;
import enums.Gender;
import exception.Exceptions;
import sercices.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicesImpl implements Services {
    List<Lessons> lessons = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    static int count;
    static  int counter;
    static int counters;

    @Override
    public Group addNewGroup(List<Group> groups) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите название группы: ");
            String groupName = scanner.nextLine();
            for (Group group : groups) {
                if (group.getGroupName().equalsIgnoreCase(groupName)) {
                    throw new Exceptions("Группа таким названием уже сушествует: ");
                }
            }
            System.out.print("Введите описание группы: ");
            String description = scanner.nextLine();
            Group group = new Group(++count , groupName, description, students, lessons);
            groups.add(group);
            System.out.println(group);
        } catch (Exceptions a) {
            System.out.println(a.getMessage());
        }
        return null;
    }

    @Override
    public void getGroupByName(List<Group> groups) {
        boolean isFalse = false;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите название группы");
            String groupName1 = scanner.nextLine();
            for (Group group1 : groups) {
                if (group1.getGroupName().equalsIgnoreCase(groupName1)) {
                    System.out.println(group1);
                    isFalse = false;
                    break;
                } else {
                    isFalse = true;
                }
            }
            if (isFalse) {
                throw new Exceptions("Група с таким названием не найдена!");
            }
        } catch (Exceptions a) {
            System.out.println(a.getMessage());
        }


    }

    @Override
    public Group updateGroupName(List<Group> groups) {
        try {
            boolean isTrue = false;
            System.out.print("Введите название группы: ");
            String oldName = new Scanner(System.in).nextLine();
            for (Group g : groups) {
                if (g.getGroupName().equalsIgnoreCase(oldName)) {
                    System.out.print("Введите новое название группы: ");
                    String newName = new Scanner(System.in).nextLine();
                    g.setGroupName(newName);
                    System.out.println(g);
                    isTrue = false;
                    break;
                } else {
                    isTrue = true;
                }
            }
            if (!isTrue) {
                throw new Exceptions("Группа " + oldName + " c таким названием не найдена");
            }

        } catch (Exceptions a) {
            System.out.println(a.getMessage());
        }
        return null;
    }

    @Override
    public void getAllGroups(List<Group> groups) {
        for (Group g : groups) {
            System.out.println(g);
        }

    }

    @Override
    public List<Student> addNewStudentToGroup(List<Group> groups) {
        Student student = new Student();
        try {
            boolean isFalse = false;
            System.out.print("Введите название группы: ");
            String groupName = new Scanner(System.in).nextLine();
            student.setId(++counter);
            for (Group a:groups) {
                if (a.getGroupName().equalsIgnoreCase(groupName)) {
                    System.out.print("Введите имя студента: ");
                    String firstName = new Scanner(System.in).nextLine();
                    if (firstName.isBlank()) {
                        throw new Exceptions("Имя не может быть пустым");
                    }
                    student.setFirstName(firstName);
                    System.out.print("Введите фамилию студента: ");
                    String lastName = new Scanner(System.in).nextLine();
                    if (lastName.isBlank()) {
                        throw new Exceptions("Фамилия не может быть пустым");
                    }
                    student.setLastName(lastName);
                    System.out.print("Ввведите email студента: ");
                    String email = new Scanner(System.in).nextLine();
                    for (Student n:students) {
                        if (n.getEmail().equalsIgnoreCase(email)) {
                            throw new Exceptions("пользователь с таким email-ом уже сушествует");
                        }
                    }
                    if (!email.contains("@")) {
                        throw new Exceptions("email должен состоять из значка '@'");
                    }
                    student.setEmail(email);
                    System.out.print("Введите возраст студента:  ");
                    int age = new Scanner(System.in).nextInt();
                    student.setAge(age);
                    if (age <= 0) {
                        throw new Exceptions("Возраст не может быть ниже 0");
                    }
                    System.out.print("Введите пол: ");
                    String gender = new Scanner(System.in).nextLine();
                    if (gender.equalsIgnoreCase(Gender.MALE.name())) {
                        student.setGender(Gender.MALE);
                    } else if (gender.equalsIgnoreCase(Gender.FEMALE.name())) {
                        student.setGender(Gender.FEMALE);
                    } else {
                        throw new Exceptions("Укажите пол правильно  ");
                    }
                    System.out.print("Введите пароль:");
                    String password = new Scanner(System.in).nextLine();
                    student.setPassword(password);
                    students.add(student);
                    System.out.println(student);
                    isFalse = false;
                    break;
                } else {
                    isFalse = true;
                }

            }if (isFalse){
                throw new Exceptions("Группа " + groupName + " c таким названием не найдена");
            }

        } catch (Exceptions s) {
            System.out.println(s.getMessage());

        }

        return null;
    }

    @Override
    public List<Student> updateStudent(List<Group> groups) {
        boolean isTrue = true;
        while (isTrue) {
            try {
                System.out.print("Введите имя студента: ");
                String oldFirstName = new Scanner(System.in).nextLine();
                System.out.print("Введите фамилию студента: ");
                String oldLastName = new Scanner(System.in).nextLine();
                for (Group a : groups) {
                    for (Student b : a.getStudents()) {
                        if (b.getFirstName().equalsIgnoreCase(oldFirstName) || b.getLastName().equalsIgnoreCase(oldLastName)) {
                            System.out.print("Ведите новое имя студента: ");
                            String newFirstName = new Scanner(System.in).nextLine();
                            System.out.print("Ведите новую фамилию студента: ");
                            String newLastName = new Scanner(System.in).nextLine();
                            System.out.println(b);
                            boolean isDuplicate = false;
                            for (Student s : students) {
                                if (s.getFirstName().equalsIgnoreCase(newLastName) && s.getLastName().equalsIgnoreCase(newFirstName)) {
                                    isDuplicate = true;
                                    break;
                                }
                            }
                            if (isDuplicate) {
                                throw new Exceptions("Студен с таким именмем уже сушествует!");
                            }
                            b.setFirstName(newFirstName);
                            b.setLastName(newLastName);
                            System.out.println(b);
                            isTrue = false;
                            break;
                        }
                    }
                    if (isTrue) {
                      break;
                    }
                }
                if (isTrue) {
                    throw new Exceptions("Студент с таким именем не найден!");
                }
            } catch (Exceptions a) {
                System.out.println(a.getMessage());
            }
        }
        return null;
    }

    @Override
    public void findStudentByFirstName(List<Group> groups) {
        try {
            boolean isFalse = false;
            for (Group a : groups) {
                for (Student b : a.getStudents()) {
                    System.out.println("Введите имя студента ");
                    String name = new Scanner(System.in).nextLine();
                    if (name.equalsIgnoreCase(b.getFirstName())) {
                        System.out.println(a);
                        isFalse = false;
                        break;
                    } else {
                        isFalse = true;
                    }
                }
            }
            if (isFalse) {
                throw new Exceptions("Группа с таким именем студента не найдена!");
            }
        } catch (Exceptions a) {
            System.out.println(a.getMessage());
        }


    }

    @Override
    public void getAllStudentsByGroupName(List<Group> groups) {
        try {
            boolean isFalse = false;
            System.out.print("Введите название группы:");
            String grName = new Scanner(System.in).nextLine();
            for (Group a : groups) {
                if (grName.equalsIgnoreCase(a.getGroupName())) {
                    System.out.println(a.getStudents());
                    isFalse = false;
                    break;
                } else {
                    isFalse = true;
                }
            }
            if (isFalse) {
                throw new Exceptions("Группа  " + grName + "  c таким названием не найдена");
            }
        } catch (Exceptions a) {
            System.out.println(a.getMessage());
        }

    }

    @Override
    public void getAllStudentsLesson(List<Group> groups) {
        try {
            boolean isTrue = false;
            System.out.print("Введите email:");
            String email = new Scanner(System.in).nextLine();
            if (!email.contains("@")) {
                throw new Exceptions("email должен состоять из значка '@'");
            }
            for (Group g : groups) {
                for (Student h : students) {
                    if (h.getEmail().equalsIgnoreCase(email)) {
                        System.out.println(g.getLessons());
                        break;
                    } else {
                        isTrue = true;
                    }
                }
            }
            if (isTrue) {
                throw new Exceptions("Студент с таким email-ом не найден");
            }

        } catch (Exceptions a) {
            System.out.println(a.getMessage());
        }

    }

    @Override
    public void deleteStudent(List<Student> groups) {
        try {
            boolean isTrue = true;
            System.out.print("Введите имя студента которого хотите удалить: ");
            String studName = new Scanner(System.in).nextLine();
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getFirstName().equalsIgnoreCase(studName)) {
                    students.remove(students.get(i));
                    System.out.println("Студент " + studName + " успешна удалена ");
                    isTrue = true;
                    break;
                } else {
                    isTrue = false;
                }

            }
            if (!isTrue) {
                throw new Exceptions("Студент " + studName + " с таким именем не найдена!");
            }
        } catch (Exceptions a) {
            System.out.println(a.getMessage());
        }
    }

    @Override
    public Lessons addNewLessonToGroup(List<Group> groups) {
        Lessons lessons1 = new Lessons();
        try {
            boolean isFalse = false;
            System.out.print("Введите название группы: ");
            String groupName = new Scanner(System.in).nextLine();
            for (Group group : groups) {
                if (group.getGroupName().equalsIgnoreCase(groupName)) {
                    lessons1.setId(++counters);
                    System.out.print("Введите тему лекции: ");
                    String lesson = new Scanner(System.in).nextLine();
                    if (lesson.isBlank()) {
                        throw new Exceptions("тема не может быть пустым");
                    }
                    lessons1.setName(lesson);
                    System.out.print("Введите описание лекции: ");
                    String description = new Scanner(System.in).nextLine();
                    lessons1.setDescription(description);
                    lessons.add(lessons1);
                    System.out.println(lessons1);
                    isFalse = false;
                    break;
                } else {
                    isFalse = true;
                }
            }
            if (isFalse) {
                throw new Exceptions("Группа " + groupName + "c таким названием не найдена");
            }

        } catch (Exceptions s) {
            System.out.println(s.getMessage());

        }

        return null;
    }

    @Override
    public void getLessonByName(List<Group> groups) {
        try {
            boolean isFalse = false;
            System.out.println("Введите название Лекции:");
            String lessonName = new Scanner(System.in).nextLine();
            for (Group a : groups) {
                for (Lessons b : a.getLessons()) {
                    if (b.getName().equalsIgnoreCase(lessonName)) {
                        System.out.println(a);
                        isFalse = false;
                        break;
                    } else {
                        isFalse = true;
                    }
                }
            }
            if (isFalse) {
                throw new Exceptions("Группа с этим названием лекции не найдена");
            }
        } catch (Exceptions a) {
            System.out.println(a.getMessage());
        }
    }


    @Override
    public void getAllLessonByGroupName(List<Group> groups) {
        try {
            boolean isFalse = false;
            System.out.print("Введите название группы: ");
            String grName = new Scanner(System.in).nextLine();
            for (Group a : groups) {
                if (a.getGroupName().equalsIgnoreCase(grName)) {
                    System.out.println(a);
                    isFalse = false;
                    break;
                } else {
                    isFalse = true;
                }
            }
            if (isFalse) {
                throw new Exceptions("Группа с таким название не найдена!");
            }
        } catch (Exceptions a) {
            System.out.println(a.getMessage());
        }

    }

    @Override
    public void deleteLesson(List<Lessons> lessons) {
        try {
            boolean isTrue = true;
            System.out.print("Введите название лекции которую хотите удалить: ");
            String lessonName = new Scanner(System.in).nextLine();
            for (int i = 0; i < lessons.size(); i++) {
                if (lessons.get(i).getName().equalsIgnoreCase(lessonName)) {
                    lessons.remove(lessons.get(i));
                    System.out.println("Лекция " + lessonName + " успешна удалена ");
                    isTrue = true;
                } else {
                    isTrue = false;
                }

            }
            if (!isTrue) {
                throw new Exceptions("Лекция " + lessonName + " с таким названием не найдена!");
            }
        } catch (Exceptions a) {
            System.out.println(a.getMessage());
        }
    }


    @Override
    public void deleteGroup(List<Group> groups) {
        try {
            boolean isTrue = true;
            System.out.print("Введите название группы которую хотите удалить: ");
            String groupName = new Scanner(System.in).nextLine();
            for (int i = 0; i < groups.size(); i++) {
                if (groups.get(i).getGroupName().equalsIgnoreCase(groupName)) {
                    isTrue = true;
                    groups.remove(groups.get(i));
                    System.out.println("Группа " + groupName + " успешна удалена ");
                } else {
                    isTrue = false;
                }

            }
            if (!isTrue) {
                throw new Exceptions("Группа " + groupName + " с таким названием не найдена!");
            }
        } catch (Exceptions a) {
            System.out.println(a.getMessage());
        }
    }
}
