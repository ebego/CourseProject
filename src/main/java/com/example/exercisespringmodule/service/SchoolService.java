package com.example.exercisespringmodule.service;

import com.example.exercisespringmodule.exceptionhandler.FileNukUGjetException;
import com.example.exercisespringmodule.entity.School;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
@Service
public class SchoolService {

    private static List<School> schoolList = new ArrayList<>();

    static {
        schoolList.add(new School(1, "Sami Frasheri", 350));
        schoolList.add(new School(2, "Ismail Qemali", 300));
        schoolList.add(new School(3, "Petro Nini Luarasi", 360));
        schoolList.add(new School(4, "Qemal Stafa", 290));
    }
    public School getSchoolById(int id) throws FileNukUGjetException {
        if(schoolList.stream().filter(s->s.getId() == id).noneMatch(p-> true) == true){
            throw new FileNukUGjetException("Not found exception");
        }
        return schoolList.stream().filter(s->s.getId() == id).findFirst().get();
    }

    public List<School> getSchools(){
        return schoolList;
    }

    public School getSchoolWithMaxStudents(){
        return schoolList.stream().max(Comparator.comparing(School::getNumriIStudenteve)).get();
    }

}
