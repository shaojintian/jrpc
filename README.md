# JRPC

a lightweight rpc framework

<!-- PROJECT SHIELDS -->

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]
<a title="Build Status" target="_blank" href="https://travis-ci.com/panjf2000/gnet"><img src="https://img.shields.io/travis/com/panjf2000/gnet?style=flat-square&logo=appveyor"></a>
<a title="Codecov" target="_blank" href="https://codecov.io/gh/panjf2000/gnet"><img src="https://img.shields.io/codecov/c/github/panjf2000/gnet?style=flat-square&logo=appveyor"></a>
<a title="Supported Platforms" target="_blank" href="https://github.com/panjf2000/gnet"><img src="https://img.shields.io/badge/platform-Linux%20%7C%20macOS%20%7C%20Windows-549688?style=flat-square&logo=appveyor"></a>
<a title="Require Go Version" target="_blank" href="https://github.com/panjf2000/gnet"><img src="https://img.shields.io/badge/go-%3E%3D1.9-30dff3?style=flat-square&logo=appveyor"></a>
<a title="Release" target="_blank" href="https://github.com/panjf2000/gnet/releases"><img src="https://img.shields.io/github/release/panjf2000/gnet.svg?color=161823&style=flat-square&logo=appveyor"></a>
<br/>
<a title="" target="_blank" href="https://golangci.com/r/github.com/panjf2000/gnet"><img src="https://golangci.com/badges/github.com/panjf2000/gnet.svg"></a>
<a title="Doc for gnet" target="_blank" href="https://gowalker.org/github.com/panjf2000/gnet?lang=zh-CN"><img src="https://img.shields.io/badge/api-reference-8d4bbb.svg?style=flat-square&logo=appveyor"></a>
<a title="gnet on Sourcegraph" target="_blank" href="https://sourcegraph.com/github.com/panjf2000/gnet?badge"><img src="https://sourcegraph.com/github.com/panjf2000/gnet/-/badge.svg?style=flat-square"></a>
<a title="Mentioned in Awesome Go" target="_blank" href="https://github.com/avelino/awesome-go#networking"><img src="https://awesome.re/mentioned-badge-flat.svg"></a>

<!-- PROJECT LOGO -->
<br />

<p align="center">
  <a href="https://github.com/shaojintian/jrpc/">
    <img src="docs/images/logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">JRPC</h3>
  <p align="center">
    <a href="https://github.com/shaojintian/jrpc"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/shaojintian/jrpc"> View Demo</a>
    ·
    <a href="https://github.com/shaojintian/jrpc/issues">Report Bug</a>
    ·
    <a href="https://github.com/shaojintian/jrpc/issues">Request Feature</a>
  </p>

</p>

 本篇README.md面向开发者 

# 🚀 功能

- [] 服务发现: 基于zookeeper注册中心
- [] 健康监测: 健康/亚健康/死亡状态切换，根据可用率(成功次数/总调用次数)
- [] 路由策略: 参数路由
- [] 负载均衡: 最小连接，轮询，加权轮询
- [] 异常重试: 重试计数/异常处理/超时处理
- [] 优雅关闭: 由server通知注册中心关闭client
- [] 优雅启动: 启动预热（加权）,延迟暴露(加hook在注册到注册中心之前)
- [] 熔断限流: interceptor,打开/半打开/关闭
- [] 业务分组: 
- [] 异步机制: 
- [] 安全体系: 
- [] 流量回放: 
- [] 动态分组: 
- [x] 支持Socket,Channel多种网络通信方式

# 🌐 展望
0.终极展望，直接rpc->service mesh
1.

## 目录

- [上手指南](#上手指南)
  - [开发前的配置要求](#开发前的配置要求)
  - [安装步骤](#安装步骤)
- [文件目录说明](#文件目录说明)
- [开发的架构](#开发的架构)
- [部署](#部署)
- [使用到的框架](#使用到的框架)
- [核心设计💡](#核心设计)
- [性能测试📊](#性能测试)
- [贡献者](#贡献者)
  - [如何参与开源项目](#如何参与开源项目)
- [版本控制](#版本控制)
- [作者](#作者)
- [赞助❤](#赞助)
- [鸣谢](#鸣谢)

### 上手指南

请将所有链接中的“shaojintian/jrpc”改为“your_github_name/your_repository”



###### 开发前的配置要求

1. xxxxx x.x.x
2. xxxxx x.x.x

###### **安装步骤**

1. Get a free API Key at [https://example.com](https://example.com)
2. Clone the repo

```sh
git clone https://github.com/shaojintian/jrpc.git
```

### 文件目录说明

eg:

```
filetree 
├── ARCHITECTURE.md
├── LICENSE.txt
├── README.md
├── /account/
├── /bbs/
├── /docs/
│  ├── /rules/
│  │  ├── backend.txt
│  │  └── frontend.txt
├── manage.py
├── /oa/
├── /static/
├── /templates/
├── useless.md
└── /util/

```





### 开发的架构 

<a>
<img src="docs/images/archi1-rpc.png" alt="archi1-rpc"/>
</a>


请阅读[ARCHITECTURE.md](https://github.com/shaojintian/jrpc/blob/master/ARCHITECTURE.md) 查阅为该项目的架构。

### 部署

暂无

### 使用到的框架

- [xxxxxxx](https://getbootstrap.com)
- [xxxxxxx](https://jquery.com)
- [xxxxxxx](https://laravel.com)


## 💡核心设计

1. xxxxx
2. xxxxx
3. xxxxx

## 📊性能测试

 1. xxxxx
 2. xxxxx


### 贡献者

请阅读**CONTRIBUTING.md** 查阅为该项目做出贡献的开发者。

#### 如何参与开源项目

贡献使开源社区成为一个学习、激励和创造的绝佳场所。你所作的任何贡献都是**非常感谢**的。

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



### 版本控制

该项目使用Git进行版本管理。您可以在repository参看当前可用版本。

### 作者

E-mail: sjt@hnu.edu.cn

知乎:[笃行er](https://www.zhihu.com/people/sjt_ai/activities)  &ensp; qq:1075803623    

 *您也可以在贡献者名单中参看所有参与该项目的开发者。*

### 版权说明

该项目签署了MIT 授权许可，详情请参阅 [LICENSE.txt](https://github.com/shaojintian/jrpc/blob/master/LICENSE.txt)

### 鸣谢

- [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
- [Img Shields](https://shields.io)
- [Choose an Open Source License](https://choosealicense.com)
- [GitHub Pages](https://pages.github.com)
- [Animate.css](https://daneden.github.io/animate.css)
- [xxxxxxxxxxxxxx](https://connoratherton.com/loaders)

### 赞助

If you like this project and want to sponsor the author, you can reward the author using Wechat or Alipay by scanning the following QR code.

<figure class="half">
  <img src="docs/images/reward_wechat.png" width="200" height="260"/>
  <img src="docs/images/reward_alipay.png" width="200" height="260"/>
</figure>
<!-- links -->

[your-project-path]: shaojintian/jrpc
[contributors-shield]: https://img.shields.io/github/contributors/shaojintian/jrpc.svg?style=flat-square
[contributors-url]: https://github.com/shaojintian/jrpc/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/shaojintian/jrpc.svg?style=flat-square
[forks-url]: https://github.com/shaojintian/jrpc/network/members
[stars-shield]: https://img.shields.io/github/stars/shaojintian/jrpc.svg?style=flat-square
[stars-url]: https://github.com/shaojintian/jrpc/stargazers
[issues-shield]: https://img.shields.io/github/issues/shaojintian/jrpc.svg?style=flat-square
[issues-url]: https://img.shields.io/github/issues/shaojintian/jrpc.svg
[license-shield]: https://img.shields.io/github/license/shaojintian/jrpc.svg?style=flat-square
[license-url]: https://github.com/shaojintian/jrpc/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/shaojintian
