[AndServer+Service 打造 Android 服务器实现 so 文件调用](https://mp.weixin.qq.com/s/Do4rGrMNFGx5HqFKM9vA1g)

#### so 文件调用
随着 Android 移动安全的高速发展，不管是为了执行效率还是程序的安全性等，关键代码下沉 native 层已成为基本操作。  
native 层的开发就是通指的 JNI/NDK 开发，通过 JNI 可以实现 java 层和 native 层（主要是 C/C++ ）的相互调用，native 层经编译后产生 so 动态链接库，so 文件具有可移植性广，执行效率高，保密性强等优点。
那么问题来了，如何调用 so 文件显得异常重要，当然你也可以**直接分析 so 文件的伪代码**，利用强悍的编程功底直接模拟关键操作，但是我想对于普通人来说头发还是比较重要的。
当前调用 so 文件的主流操作应该是：  
1，基于 Unicorn 的各种实现（还在学习中，暂且不表）  
2，Android 服务器的搭建，在 App 内起 http 服务完成调用 so 的需求（当然前提是过了 so 的效验等操作）  
至于为什么选用 AndServer，好吧，不为什么，只是因为搜索到了它  
为什么结合 Service，在学习 Android 开发的时候了解到了 Service 的生命周期，个人理解用 Service 去创建 Http 服务比较好。  
当然也有 Application 的简单使用，因为在正式环境中，大多数 so 文件的逻辑中都有 context 的一些包名了，签名了的效验等，自定义 Application 的话获取 context 传参就好了。