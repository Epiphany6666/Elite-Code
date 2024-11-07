import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import {DEFAULT_USER} from "@/constants/user";

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
