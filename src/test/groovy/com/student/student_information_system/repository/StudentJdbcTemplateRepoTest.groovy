import com.student.student_information_system.domain.Student
import com.student.student_information_system.mapper.StudentMapper
import com.student.student_information_system.repository.StudentRepository
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import spock.lang.Specification

class StudentJdbcTemplateRepoTest extends Specification {
    NamedParameterJdbcTemplate namedParameterJdbcTemplate = Mock(NamedParameterJdbcTemplate)
    StudentMapper studentMapper = Mock(StudentMapper)
   StudentRepository studentRepository = new StudentRepository(namedParameterJdbcTemplate,studentMapper)

   def "should add student details"(){
    given :
    def student = Student
            .builder().stdId(1).stdName("John").stdEmail("abc").stdPhone("123").stdAddress("USA").stdDepartment("CSE").build()
    and :
    1 * namedParameterJdbcTemplate.update(studentRepository.INSERT_STUDENT, _ as MapSqlParameterSource)
    when :
    studentRepository.insertStudent(student)
    then :  
    noExceptionThrown()
    }

    def "should update student details"(){
        given :
        def student = Student
                .builder().stdId(1).stdName("John").stdEmail("abc").stdPhone("123").stdAddress("USA").stdDepartment("CSE").build()
        and :
        1 * namedParameterJdbcTemplate.update(studentRepository.UPDATE_STUDENT, _ as MapSqlParameterSource)
        when :
        studentRepository.updateStudent(student)
        then :  
        noExceptionThrown()
    }
  
   def "should delete student details"(){
    given :
    def stdId = 1
    and :
    1 * namedParameterJdbcTemplate.update(studentRepository.DELETE_STUDENT, _ as MapSqlParameterSource)
    when :
    studentRepository.deleteStudent(stdId)
    then :  
        noExceptionThrown()
    }

    def "should return student details"(){
        given :
        def student = Student
                .builder().stdId(1).stdName("John").stdEmail("abc").stdPhone("123").stdAddress("USA").stdDepartment("CSE").build()
        def stdId = 1
        and :
        studentMapper.mapRow(_) >> student
        1 * namedParameterJdbcTemplate.queryForObject(studentRepository.GET_STUDENT, _ as MapSqlParameterSource, studentMapper)
        when :
        studentRepository.getStudent(stdId)
        then :  
        noExceptionThrown()
    }

    def "should return all student details"(){
        given :
        def student = Student
                .builder().stdId(1).stdName("John").stdEmail("abc").stdPhone("123").stdAddress("USA").stdDepartment("CSE").build()
        and :
        studentMapper.mapRow(_) >> student
        1 * namedParameterJdbcTemplate.query(studentRepository.GET_ALL_STUDENTS, studentMapper)
        when :
        studentRepository.getAllStudents()
        then :  
        noExceptionThrown()
    }
}