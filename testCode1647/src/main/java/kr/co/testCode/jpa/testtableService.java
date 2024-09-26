package kr.co.testCode.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class testtableService {

	@Autowired 
	private testtableRepository testtableRepository;
	
	public List<testtableVo> findAll(){
		List<testtableVo> testtables = new ArrayList<>();
		testtableRepository.findAll().forEach(
					e->testtables.add(e)
				);
		return testtables;
	}
	
	
    public Optional<testtableVo> findById(Integer mbrNo) {
        Optional<testtableVo> member = testtableRepository.findById(mbrNo);
        return member;
    }

    public void deleteById(Integer mbrNo) {
        testtableRepository.deleteById(mbrNo);
    }

    public testtableVo save(testtableVo member) {
        testtableRepository.save(member);
        return member;
    }

    public void updateById(Integer mbrNo, testtableVo member) {
        Optional<testtableVo> e = testtableRepository.findById(mbrNo);

        if (e.isPresent()) {
        	member.setId(mbrNo);
            testtableRepository.save(member);
        }
        
//        if (e.isPresent()) {
//            e.get().setId(member.getId());
//            e.get().setName(member.getName());
//            e.get().setPhone(member.getPhone());
//            testtableRepository.save(member);
//        }

        
//        if (e.isPresent()) {
//            e.get().setId(mbrNo);
//            e.get().setName(member.getName());
//            e.get().setPhone(member.getPhone());
//            testtableRepository.save(e);
//        }
    }
}
