export declare interface LoginUserVO {
  tokenHead: string
  token: string
}

export declare interface UserRegisterDTO {
  username: string
  password: string
  checkPassword: string
}

export declare interface LoginForm {
  username: string
  password: string
}

export declare interface UserAddDTO {
  username: string,
  avatar: string,
  nickName: string,
  password: string,
  profile: string,
  roles: []
}
