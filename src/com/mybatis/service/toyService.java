package mybatis.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mybatis.dao.toyMapper;
import mybatis.pojo.Toy;

@Service("toyService")
@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
public class toyService {
@Resource(name="toyMapper")
private toyMapper toyMapper;

public Toy findById(Integer id){
	
	return toyMapper.findById(id);
}

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,
rollbackFor=Exception.class)
public int addtoy(Toy to){
	return toyMapper.addtoy(to);
}

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,
rollbackFor=Exception.class)
public int remove(Integer id){
	
	return toyMapper.remove(id);
}

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,
rollbackFor=Exception.class)
public int modify(Toy to){
	
	return toyMapper.modify(to);
}

public List<Toy> findAll(){
	return toyMapper.find();
}

public List<Toy> findByName(String name){
	
	return toyMapper.findByName(name);
}
}
