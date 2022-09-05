# HomoAC

**By Homo, For Homo**

第114514代发包检测型反作弊

## 为何选择HomoAC

* HomoAC是快
创建多个线程用于检测发包，不拖慢服务端速度
  
* HomoAC是打滑
从10个甚至9个作弊程序的源码中分析发包，包括但不限于开源和开裂
  
## 安装

1. 确保服务端版本介于1.12.2-1.18.2

2. 获取PacketEvents 2.0（或从depends文件夹下载），放入plugins中，然后从Releases下载HomoAC，同样放入plugins

3. HomoAC无需任何配置即可使用，默认配置支持原版封禁、LiteBans和CMI
   **如果同时安装了LiteBans和CMI，命令可能出现冲突，请将封禁指令设置中的“ban”改为“lban”
   
##使用

**不开玩笑了，这确实是一个正常工作的反作弊**

* 在config.yml调整模块的开关
