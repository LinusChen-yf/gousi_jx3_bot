# 构思剑网三qq机器人插件
<img src="https://s1.ax1x.com/2022/08/08/vQLbB4.png" width="200px">

## 安装教程
### 安装mirai console机器人程序
安装教程: https://github.com/iTXTech/mcl-installer
### 下载release页面中的jar包
下载地址: https://github.com/Time-xg/gousi_jx3_bot/releases/tag/v1.0.0
选择gousi_jx3_bot-x.x.x.mirai2.jar文件下载

## 使用教程
### 将下载插件的jar包移动到机器人程序的文件夹下
路径为机器人目录下的`/plugins`目录下

### 下载`chat-command`插件
在mcl目录下执行命令:`./mcl --update-package net.mamoe:chat-command --channel stable --type plugin`

### 启动动mirai console机器人程序并登陆
启动mirai console成功之后,可以输入`?`指令查看所有的指令功能
使用`login qq账号 qq密码`进行登陆操作(期间可能会碰到安全验证问题,根据提示操作即可)

### 给剑网三机器人分配命令权限
在启动mirai console机器人之后,执行`/perm permit * top.timewl.jx3:*`授予权限,即可使用啦~
