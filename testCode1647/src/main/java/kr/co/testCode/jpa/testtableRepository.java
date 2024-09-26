package kr.co.testCode.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface testtableRepository extends JpaRepository<testtableVo, Integer>{

	public Optional<testtableVo> findById(Integer id);
	public Optional<testtableVo> findByName(String name);
	public Optional<testtableVo> findByPhone(String phone);
}
