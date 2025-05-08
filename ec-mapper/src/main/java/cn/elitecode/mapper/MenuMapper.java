package cn.elitecode.mapper;

import cn.elitecode.model.dto.menu.MenuQueryDTO;
import cn.elitecode.model.entity.Menu;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
* menu(菜单权限表)
*/
public interface MenuMapper {

    /**
     * 插入菜单信息
     * @param menu
     */
    void insertMenu(Menu menu);

    /**
     * 根据id数组批量删除菜单信息
     * @param menuIds
     */
    void deleteByMenuIds(@Param("menuIds") Long[] menuIds);

    /**
     * 根据id修改菜单信息
     * @param menu
     */
    void updateMenuById(Menu menu);

    /**
     * 根据分页条件查询菜单信息
     * @param menuQueryDTO
     * @return
     */
    List<Menu> selectMenuListByPage(MenuQueryDTO menuQueryDTO);

    /**
     * 根据分页条件查询菜单信息数量
     * @param menuQueryDTO
     * @return
     */
    Long getTotalByPage(MenuQueryDTO menuQueryDTO);

    /**
     * 根据id查询菜单信息
     * @param menuId
     * @return
     */
    Menu selectMenuById(Long menuId);

    /**
     * 根据用户id查询菜单列表
     * @param userId
     * @return
     */
    List<Menu> selectMenuListByUserId(Long userId);

    /**
     * 根据角色id查询菜单列表
     * @param roleId
     * @param menuCheckStrictly
     * @return 选中菜单列表
     */
    List<Long> selectMenuListByRoleId(@Param("roleId") Long roleId, @Param("menuCheckStrictly") boolean menuCheckStrictly);
}




