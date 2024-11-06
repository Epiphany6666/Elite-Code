import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import ACCESS_ENUM from "@/app/access/accessEnum";

// 默认用户
const DEFAULT_USER: API.LoginUserVO = {
    userName: "未登录",
    userProfile: "暂无简介",
    userAvatar: "/assets/notLoginUser.png",
    userRole: ACCESS_ENUM.NOT_LOGIN,
};

/**
 * 登录用户全局状态
 */
export const loginUserSlice = createSlice({
    name: "loginUser",
    initialState: DEFAULT_USER,
    reducers: {
        setLoginUser: (state, action: PayloadAction<API.LoginUserVO>) => {
            // 我们每次返回的都是一个新对象，防止在外面被修改2:30:54
            return {
                ...action.payload,
            };
        },
    },
});

// 修改状态
export const { setLoginUser } = loginUserSlice.actions;

export default loginUserSlice.reducer;
