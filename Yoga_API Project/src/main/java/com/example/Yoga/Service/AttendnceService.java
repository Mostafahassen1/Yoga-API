
package com.example.Yoga.Service;


import com.example.Yoga.DAO.AttendanceDAO;
import com.example.Yoga.EntityYoga.Attendanceing;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendnceService implements BaseService<Attendanceing>{

    private AttendanceDAO  attendanceDAO ;

    public AttendnceService(AttendanceDAO attendanceDAO) {
        this.attendanceDAO = attendanceDAO;
    }

    @Override
    public List<Attendanceing> findAll() {
        return attendanceDAO.findAll() ;
    }

    @Override
    public Attendanceing findById(int id) {
        Optional<Attendanceing> attend = attendanceDAO.findById(id) ;
        return attend.orElse(null) ;
    }

    @Override
    public List<Attendanceing> saveAll(List<Attendanceing> entity) {

        return attendanceDAO.saveAll(entity);
    }
}


