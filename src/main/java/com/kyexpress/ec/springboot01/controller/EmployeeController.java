package com.kyexpress.ec.springboot01.controller;

import com.kyexpress.ec.springboot01.dao.DepartmentDao;
import com.kyexpress.ec.springboot01.dao.EmployeeDao;
import com.kyexpress.ec.springboot01.entities.Department;
import com.kyexpress.ec.springboot01.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.Collection;

@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeDao employeeDao;

    //查询所有员工返回员工列表
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @Autowired
    private DepartmentDao departmentDao;

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //获取所有部门的名称
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts",depts);
        return "emp/add";
    }

    //员工添加
    @PostMapping("/emp")
    public String add(Employee employee){
        System.out.println(employee);
        //保存员工信息
        employeeDao.save(employee);
        //重定向到员工列表
        return "redirect:/emps";
    }

    //来到员工修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model ){
        Employee emp = employeeDao.get(id);
        model.addAttribute("emp",emp);
        //获取所有部门的名称
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts",depts);
        return "emp/add";
    }

    //修改员工信息
    @PutMapping("/emp")
    public String edit(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
