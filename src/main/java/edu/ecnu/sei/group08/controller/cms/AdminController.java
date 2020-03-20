package edu.ecnu.sei.group08.controller.cms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import edu.ecnu.sei.group08.bo.GroupPermissionsBO;
import edu.ecnu.sei.group08.common.utils.ResponseUtil;
import edu.ecnu.sei.group08.dto.admin.*;
import edu.ecnu.sei.group08.model.RoleDO;
import edu.ecnu.sei.group08.model.PermissionDO;
import edu.ecnu.sei.group08.model.UserDO;
import edu.ecnu.sei.group08.service.AdminService;
import edu.ecnu.sei.group08.vo.PageResponseVO;
import edu.ecnu.sei.group08.vo.UnifyResponseVO;
import edu.ecnu.sei.group08.vo.UserInfoVO;
import io.github.talelin.core.annotation.AdminRequired;
import io.github.talelin.core.annotation.RouteMeta;
import edu.ecnu.sei.group08.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by lin on 2019/06/12.
 * License MIT
 */

@RestController
@RequestMapping("/cms/admin")
@Validated
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/permission")
    @AdminRequired
    @RouteMeta(permission = "查询所有可分配的权限", module = "管理员")
    public Map<String, List<PermissionDO>> getAllPermissions() {
        return adminService.getAllStructualPermissions();
    }


    @GetMapping("/users")
    @AdminRequired
    @RouteMeta(permission = "查询所有用户", module = "管理员")
    public PageResponseVO getUsers(
            @RequestParam(name = "role_id", required = false)
            @Min(value = 1, message = "{role_id}") Long roleId,
            @RequestParam(name = "count", required = false, defaultValue = "10")
            @Min(value = 1, message = "{count}") Long count,
            @RequestParam(name = "page", required = false, defaultValue = "0")
            @Min(value = 0, message = "{page}") Long page) {
        IPage<UserDO> iPage = adminService.getUserPageByRoleId(roleId, count, page);
        List<UserInfoVO> userInfos = iPage.getRecords().stream().map(user -> {
            List<RoleDO> groups = roleService.getUserGroupsByUserId(user.getId());
            return new UserInfoVO(user, groups);
        }).collect(Collectors.toList());
        return PageResponseVO.genPageResult(iPage.getTotal(), userInfos, page, count);
    }

    @PutMapping("/user/{id}/password")
    @AdminRequired
    @RouteMeta(permission = "修改用户密码", module = "管理员")
    public UnifyResponseVO changeUserPassword(@PathVariable @Positive(message = "{id}") Long id, @RequestBody @Validated ResetPasswordDTO validator) {
        adminService.changeUserPassword(id, validator);
        return ResponseUtil.generateUnifyResponse(2);
    }

    @DeleteMapping("/user/{id}")
    @AdminRequired
    @RouteMeta(permission = "删除用户", module = "管理员")
    public UnifyResponseVO deleteUser(@PathVariable @Positive(message = "{id}") Long id) {
        adminService.deleteUser(id);
        return ResponseUtil.generateUnifyResponse(3);
    }


    @PutMapping("/user/{id}")
    @AdminRequired
    @RouteMeta(permission = "管理员更新用户信息", module = "管理员")
    public UnifyResponseVO updateUser(@PathVariable @Positive(message = "{id}") Long id, @RequestBody @Validated UpdateUserInfoDTO validator) {
        adminService.updateUserInfo(id, validator);
        return ResponseUtil.generateUnifyResponse(4);
    }

    @GetMapping("/group")
    @AdminRequired
    @RouteMeta(permission = "查询所有权限组及其权限", module = "管理员")
    public PageResponseVO getGroups(
            @RequestParam(name = "count", required = false, defaultValue = "10")
            @Min(value = 1, message = "{count}") Long count,
            @RequestParam(name = "page", required = false, defaultValue = "0")
            @Min(value = 0, message = "{page}") Long page) {
        IPage<RoleDO> iPage = adminService.getGroupPage(page, count);
        return PageResponseVO.genPageResult(iPage.getTotal(), iPage.getRecords(), page, count);
    }


    @GetMapping("/group/all")
    @AdminRequired
    @RouteMeta(permission = "查询所有权限组", module = "管理员")
    public List<RoleDO> getAllGroup() {
        List<RoleDO> groups = adminService.getAllGroups();
        return groups;
    }

    @GetMapping("/group/{id}")
    @AdminRequired
    @RouteMeta(permission = "查询一个权限组及其权限", module = "管理员")
    public GroupPermissionsBO getGroup(@PathVariable @Positive(message = "{id}") Long id) {
        GroupPermissionsBO groupPermissions = adminService.getGroup(id);
        return groupPermissions;
    }


    @PostMapping("/group")
    @AdminRequired
    @RouteMeta(permission = "新建权限组", module = "管理员")
    public UnifyResponseVO createGroup(@RequestBody @Validated NewGroupDTO validator) {
        adminService.createGroup(validator);
        return ResponseUtil.generateUnifyResponse(13);
    }


    @PutMapping("/group/{id}")
    @AdminRequired
    @RouteMeta(permission = "更新一个权限组", module = "管理员")
    public UnifyResponseVO updateGroup(@PathVariable @Positive(message = "{id}") Long id,
                                       @RequestBody @Validated UpdateGroupDTO validator) {
        adminService.updateGroup(id, validator);
        return ResponseUtil.generateUnifyResponse(5);
    }

    @DeleteMapping("/group/{id}")
    @AdminRequired
    @RouteMeta(permission = "删除一个权限组", module = "管理员")
    public UnifyResponseVO deleteGroup(@PathVariable @Positive(message = "{id}") Long id) {
        adminService.deleteGroup(id);
        return ResponseUtil.generateUnifyResponse(6);
    }

    @PostMapping("/permission/dispatch")
    @AdminRequired
    @RouteMeta(permission = "分配单个权限", module = "管理员")
    public UnifyResponseVO dispatchPermission(@RequestBody @Validated DispatchPermissionDTO validator) {
        adminService.dispatchPermission(validator);
        return ResponseUtil.generateUnifyResponse(7);
    }

    @PostMapping("/permission/dispatch/batch")
    @AdminRequired
    @RouteMeta(permission = "分配多个权限", module = "管理员")
    public UnifyResponseVO dispatchPermissions(@RequestBody @Validated DispatchPermissionsDTO validator) {
        adminService.dispatchPermissions(validator);
        return ResponseUtil.generateUnifyResponse(7);
    }

    @PostMapping("/permission/remove")
    @AdminRequired
    @RouteMeta(permission = "删除多个权限", module = "管理员")
    public UnifyResponseVO removePermissions(@RequestBody @Validated RemovePermissionsDTO validator) {
        adminService.removePermissions(validator);
        return ResponseUtil.generateUnifyResponse(8);
    }

}
