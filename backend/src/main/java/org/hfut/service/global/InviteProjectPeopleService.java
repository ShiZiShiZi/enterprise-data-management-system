package org.hfut.service.global;

import org.hfut.mapper.ProjectPeopleMapper;
import org.hfut.mapper.WaitingRegisterPeopleMapper;
import org.hfut.pojo.ProjectPeople;
import org.hfut.pojo.ProjectPeopleExample;
import org.hfut.pojo.WaitingRegisterPeople;
import org.hfut.pojo.WaitingRegisterPeopleExample;
import org.hfut.tool.global.AddProjectPeopleTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * AddProjectPeopleService
 *
 * @author WeiXin
 * @date 2019/1/14
 **/
@Service
public class InviteProjectPeopleService {

    private final static int PROJECT_PEOPLE = 1;
    private final static int DEPARTMENT_MANAGER = 2;
    private final static int FINANCIAL_STAFF = 3;
    private WaitingRegisterPeopleMapper waitingRegisterPeopleMapper;
    private ProjectPeopleMapper projectPeopleMapper;
    private boolean reInvite;
    private WaitingRegisterPeople waitingRegisterPeople;

    @Autowired
    public InviteProjectPeopleService(WaitingRegisterPeopleMapper waitingRegisterPeopleMapper,
                                      ProjectPeopleMapper projectPeopleMapper) {
        this.waitingRegisterPeopleMapper = waitingRegisterPeopleMapper;
        this.projectPeopleMapper = projectPeopleMapper;
        reInvite = false;
    }

    public WaitingRegisterPeople addWaitingRegisterPeople(ProjectPeople inviter, String name, String phoneNumber,
                                                          String email, Integer type, Integer targetDepartmentId) {


        if(reInvite) {
            return waitingRegisterPeople;
        }


        final byte projectPeoplePermission = 1;
        final byte departmentManagerPermission = 3;
        final byte financialStaffPermission = 4;
        final byte waiting = 0;
        WaitingRegisterPeople waitingRegisterPeople = new WaitingRegisterPeople();

        waitingRegisterPeople.setName(name);
        waitingRegisterPeople.setEmail(email);
        waitingRegisterPeople.setPhoneNumber(phoneNumber);
        waitingRegisterPeople.setInviterId(inviter.getId());
        waitingRegisterPeople.setState(waiting);

        switch(type) {
            case PROJECT_PEOPLE:
                waitingRegisterPeople.setTargetDepartmentId(inviter.getDepartmentId());
                waitingRegisterPeople.setTargetPermission(projectPeoplePermission);
                break;
            case DEPARTMENT_MANAGER:
                waitingRegisterPeople.setTargetDepartmentId(targetDepartmentId);
                waitingRegisterPeople.setTargetPermission(departmentManagerPermission);
                break;
            case FINANCIAL_STAFF:
                waitingRegisterPeople.setTargetDepartmentId(null);
                waitingRegisterPeople.setTargetPermission(financialStaffPermission);
                break;
            default:
        }
        waitingRegisterPeopleMapper.insert(waitingRegisterPeople);
        return waitingRegisterPeople;
    }

    public boolean invitePeople(ProjectPeople inviter, WaitingRegisterPeople waitingRegisterPeople, Integer type) {
        String position;

        switch(type) {
            case PROJECT_PEOPLE:
                position = "项目人员";
                break;
            case DEPARTMENT_MANAGER:
                position = "部门管理员";
                break;
            case FINANCIAL_STAFF:
                position = "财务人员";
                break;
            default:
                throw new RuntimeException("WaitingRegisterPeopleTargetPermissionError");
        }
        try {
            AddProjectPeopleTool
                    .sendEmail(waitingRegisterPeople.getEmail(), waitingRegisterPeople.getName(), inviter.getName(),
                               position, waitingRegisterPeople.getId(), waitingRegisterPeople.getTargetPermission());
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    public boolean canInvite(Map<String, Object> targetInfoMap) {
        List<WaitingRegisterPeople> waitingRegisterPeopleList = selectWaitingRegisterPeopleByOr(targetInfoMap);
        ProjectPeopleExample example = new ProjectPeopleExample();

        if(waitingRegisterPeopleList.size() == 0) {
            reInvite = false;
        } else {
            reInvite = true;
            waitingRegisterPeople = waitingRegisterPeopleList.get(0);
        }

        example.or().andPhoneNumberEqualTo((String) targetInfoMap.get("phoneNumber"));
        example.or().andEmailEqualTo((String) targetInfoMap.get("email"));
        return projectPeopleMapper.selectByExample(example).size() == 0;
    }

    private List<WaitingRegisterPeople> selectWaitingRegisterPeopleByOr(Map<String, Object> exampleMap) {
        WaitingRegisterPeopleExample example = new WaitingRegisterPeopleExample();

        example.or().andPhoneNumberEqualTo((String) exampleMap.get("phoneNumber"));
        example.or().andEmailEqualTo((String) exampleMap.get("email"));
        return waitingRegisterPeopleMapper.selectByExample(example);
    }
}
