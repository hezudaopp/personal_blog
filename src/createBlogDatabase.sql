create database blog;
use blog;
-- phpMyAdmin SQL Dump
-- version 3.1.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 24, 2010 at 03:16 PM
-- Server version: 5.1.33
-- PHP Version: 5.2.9

SET FOREIGN_KEY_CHECKS=0;

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `blog`
--

-- --------------------------------------------------------

--
-- Table structure for table `blog`
--

CREATE TABLE IF NOT EXISTS `blog` (
  `blog_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `blog_user_id` bigint(20) unsigned NOT NULL,
  `blog_title` text NOT NULL,
  `blog_content` longtext NOT NULL,
  `blog_createdate` datetime NOT NULL,
  `blog_updatedate` datetime NOT NULL,
  PRIMARY KEY (`blog_id`),
  KEY `blog_ibfk_1` (`blog_user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=26 ;

--
-- Dumping data for table `blog`
--

INSERT INTO `blog` (`blog_id`, `blog_user_id`, `blog_title`, `blog_content`, `blog_createdate`, `blog_updatedate`) VALUES
(2, 2, '深悉正则(pcre)最大回溯/递归限制\r\nby 雪候鸟', '今天,Tank问了一个问题, 对于如下的正则:\r\n', '2010-06-11 17:53:26', '2010-06-11 17:53:26'),
(5, 3, 'Comic Life – 傻瓜式漫画创作 | 小众软件 > 趣味软件', '单二狗，不仅有个杯具的名字，还有更加杯具的生活。为了把自己的不开心画成漫画，给大家开心一下，他急需为照片添加动漫对白的程序。Comic Life 满足了他全部需求。程序内置大量漫画排版，可以在一页纸自由加入图像，跟上贱贱的对白，操作直观傻瓜，会用 Word 就会用这货。Comic Life 只能免费试用30天，不过单二狗觉得自己这种癖好能坚持30天还不一定。@appinn', '2010-06-12 11:24:19', '2010-06-12 11:24:19'),
(8, 3, 'PHP调试技术手册发布(1.0.0 pdf)', '<p><a target="_blank" href="http://blog.csdn.net/heiyeshuwu">黑夜路人</a>前段时 间, 本着分享/总结的精神, 计划要总结下PHP常用的调试技术, 就一些问题找到了我..</p>\r\n<p>如今第一版的PHP调试技术手册已经发布.</p>\r\n<p>冠以我名, 我甚感惶恐, 只能一并赞下小黑的nice了~</p>\r\n<p>下载地址: <a href="http://heiyeluren-doc.googlecode.com/files/PHP-Debug-Manual-public.pdf">http://heiyeluren-doc.googlecode.com/files/PHP-Debug-Manual-public.pdf</a></p>\r\n<p>目录:</p>\r\n<pre linenum="off" class="sh_bash" name="code"><ol><li>1 内置API输出调试</li><li>1.1 基本调试API</li><li>1.1.1 echo (print):</li><li>1.1.2 printf</li><li>1.1.3 print_r、var_dump(var_export)、debug_zval_dump</li><li>1.2 错误控制和日志记录调试</li><li>1.2.1 错误选项控制</li><li>1.2.2 错误抛出和处理</li><li>1.2.3 使用错误抑制符</li><li>1.2.4 日志记录</li><li>2 浏览器调试</li><li>2.1 页面输出调试</li><li>2.2 FirePHP  调试</li><li>2.2.1 普通变量监测</li><li>2.2.2 调用栈监测</li><li>2.2.3 监测抛出异常</li><li>2.2.4 组显示信息</li><li>3 IDE 调试</li><li>3.1 基本常用IDE介绍</li><li>3.1.1 Vim</li><li>3.1.2 Zend Studio</li><li>3.1.3 Eclipse</li><li>3.1.4 NetBeans</li><li>3.2 IDE调试</li><li>3.2.1 Zend Studio + Zend Debugger</li><li>3.2.2 Eclipse (PDT) + Xdebug</li><li>3.2.3 Vim + Xdebug + DBGp</li><li>4 PHP 性能调试技术</li><li>4.1 基本时间占用监测</li><li>4.2 使用  Xdebug 进行性能分析</li><li>4.2.1 安装配置：</li><li>4.3 APD(Advanced PHP Debugger)</li><li>4.3.1 安装配置</li><li>4.3.2 使用APD</li><li>4.4 使用Xhprof 进行性能分析</li><li>4.4.1 Xhprof  的优点：</li><li>5 PHP单元测试技术</li><li>5.1 PHPUnit</li></ol></pre>', '2010-06-12 11:27:02', '2010-06-21 13:49:49'),
(9, 2, 'Google Earth iPad版评测', '<p>大名鼎鼎的谷歌地球（</p>\r\n<a href="http://www.williamlong.info/google/" target="_blank">Google Earth</a>\r\n<p>）首次推出了免费</p>\r\n<a href="http://www.williamlong.info/archives/2205.html" target="_blank">iPad</a>\r\n<p>版 本，版本号3.0，其界面和功能与早先推出的iPhone版类似，还专门为iPad的大屏幕优化了显示效果。目前的iPad版Google  Earth官方支持简体中文，而且完全免费，效果非常不错，属于iPad必装应用之一。</p>\r\n<p>　　iPad版Google  Earth一经推出，就占领了iTunes应用商店的免费iPad应用第一名，可见其受欢迎的程度。由于iPhone版的同名应用就很知名，具有更佳使用 体验的iPad版自然更会得到大量关注，加之相关报道较多，使得这个应用大受欢迎。</p>\r\n<p>　　<strong>Google  Maps和Google Earth</strong></p>\r\n<p>　　iPad内置了Google地图（Google  Maps），可以方便的查看传统地图和卫星地图，不过iPad版Google Maps功能很少，界面简单，缺少附加图层，最主要的是不能像Google  Earth那样旋转地图，功能并不如Google Earth那样强大。</p>\r\n<p>　　iPad内置了Google地图，有传统、卫星、混合、地形 四种地图，还可以查看交通状况图层。经测试，混合地图并没有把传统地图和卫星地图混合在一起，可能这项功能在中国还有限制。</p>\r\n<p style="text-align: center;"><img src="http://www.williamlong.info/upload/2205_9.jpg" alt="Google Earth iPad" /></p>\r\n<p>　　不过，iPad版 Google地图比iPad版Google Earth的好处在于多了街景地图，在地图上放置一个大头针后，按住上面的人像，就可以查看街景地图了。</p>\r\n<p style="text-align: center;"><img src="http://www.williamlong.info/upload/2205_10.jpg" alt="Google Earth iPad" /></p>\r\n<p>　　<strong>操作 体验</strong></p>\r\n<p>　　iPad版的Google  Earth的操作性令人印象深刻，用户使用两个手指就能方便地放大、缩小、旋转谷歌地球，就如同玩弄一个真是的地球仪一样方便，操作感带来很出色的使用体 验。</p>\r\n<p style="text-align: center;"><img src="http://www.williamlong.info/upload/2215_1.jpg" alt="Google Earth iPad" /></p>\r\n<p>　　和iPhone版的 Google Earth不同的是，iPad具有更大的显示分辨率，对于桌面版Google  Earth的优势则是iPad具有良好的移动性，用户可以在大街上使用Google Earth软件。</p>\r\n<p>　　和桌面版Google  Earth不同的是，iPad版Google  Earth支持GPS定位，GPS定位是iPad的特色功能，用户点屏幕上方的圆圈即可定位自己的位置，GPS定位的显示效果如下图，和iPad内置的 Google地图大体一致。</p>\r\n<p style="text-align: center;"><img src="http://www.williamlong.info/upload/2215_2.jpg" alt="Google Earth\r\niPad" /></p>\r\n<p>　　<strong>功 能特色</strong></p>\r\n<p>　　相比桌面版的Google Earth，iPad的Google  Earth功能较少，只有&ldquo;选项&rdquo;和&ldquo;图层&rdquo;两个菜单，选项的信息包括&ldquo;位置&rdquo;和&ldquo;自动倾斜&rdquo;，还可以删除缓存和历史记录，版本说明中显示的是3.0版 本。</p>\r\n<p style="text-align: center;"><img src="http://www.williamlong.info/upload/2215_3.jpg" alt="Google Earth iPad" /></p>\r\n<p>　　图层也只有少量几个主要 图层，一些桌面版Google  Earth的重要图层都存在，界面上的地理内容要多于iPad版Google地图。图层包括：地方、商业、Panoramio照片、维基百科、边界和地 名、道路、地形。</p>\r\n<p style="text-align: center;"><img src="http://www.williamlong.info/upload/2215_4.jpg" alt="Google Earth iPad" /></p>\r\n<p>　　<strong>Panoramio 图层</strong></p>\r\n<p>　　Panoramio图层是iPad版Google  Earth唯一的一个UGC（用户产生内容）的图层，在上面可以看到世界各地网民拍摄的数码照片，也有很多<a href="http://www.panoramio.com/user/williamlong" target="_blank">我拍摄的照片</a>。当然，这个图层也会让 CCAV的军事专家们惊恐万分了，网民拍摄的国家军事机密又要被上传到Google上了。</p>\r\n<p style="text-align: center;"><img src="http://www.williamlong.info/upload/2215_5.jpg" alt="Google Earth iPad" /></p>\r\n<p>　　Google  Earth上的另一个图层：Google Earth社区的标注图层并没有出现在iPad版Google  Earth，具体原因不明，有可能是因为网民在谷歌地球论坛上传的地标数量太大，质量则良朽不齐，不适合手持设备使用吧。</p>\r\n<p>　　维基百科图层 也是一个内容信息丰富的图层，在中文iPad界面下，维基百科图层的信息来源于中文的维基百科。</p>\r\n<p style="text-align: center;"><img src="http://www.williamlong.info/upload/2215_6.jpg" alt="Google Earth iPad" /></p>\r\n<p>　　<strong>道路图 层</strong></p>\r\n<p>　　在iPad版Google  Earth上，交通地图终于可以和卫星地图混合在一起了，选中&ldquo;道路&rdquo;图层之后，就可以将卫星地图和传统地图合并。然而，经过测试，对于中国地区，卫星地 图和交通地图混合后具有明显的偏差，交通地图上的道路和实际卫星地图的道路不相匹配，问题的根源应该在于交通地图的地理数据不准确，Google  Earth中国交通地图的数据来自Google地图的中国的地图合作商，中国目前有种可笑说法就是，提供具有位置偏差的地图可以保护中国的&ldquo;国家军事机 密&rdquo;，显然Google Earth也在遵守中国的法律来保护中国随处可见的&ldquo;机密&rdquo;。</p>\r\n<p style="text-align: center;"><img src="http://www.williamlong.info/upload/2215_7.jpg" alt="Google Earth iPad" /></p>\r\n<p>　　这种地理位置偏差的情况 只在中国大陆地区存在，例如查看深圳地图会发现滨海大道已经在大海里，而几公里之外的香港地图却没有任何偏差。</p>\r\n<p style="text-align: center;"><img src="http://www.williamlong.info/upload/2215_8.jpg" alt="Google Earth iPad" /></p>\r\n<p>　　<strong>不足之 处</strong></p>\r\n<p>　　Google Earth  iPad如果说有不足的话，稳定性应该是最大的不足，使用过程不很稳定，如果点击一些图层信息，经常会出现自动退出程序的情况，不知道是什么原因。反观 Google Maps iPad则没有自动退出的情况发生。</p>\r\n<p>　　总而言之，iPad版的Google  Earth大体上浏览体验非常不错，仿佛Google Earth一开始就是为iPad设计的一样。</p>\r\n<p>　　Google Earth  iPad应用地址：<a href="http://itunes.apple.com/us/app/google-earth/id293622097" target="_blank">http://itunes.apple.com/us/app/google-earth/id293622097</a></p>', '2010-06-12 11:27:02', '2010-06-21 14:08:11'),
(10, 3, '“彩虹之国”南非', '南非世界杯即将拉开战幕，对于将赴南非观赛的中国球迷来说，除了看球之外，南非的迷人风光也不能错过。今年3月我曾经去过素有“彩虹之国”美誉的南非，那里绚丽的风光、独特的人文风情至今还历历在目。\r\n\r\n　　比勒陀利亚：近距离观察野生动物\r\n\r\n　　我们南非之旅的首站是南非的行政首都比勒陀利亚（Pretoria）。我们入住的酒店名字是Farm Inn，这是一家很独特的农场酒店，位于比勒陀利亚东郊，这家酒店最独特的一点是酒店旁边就是一个有包括狮子、猎豹等动物的野生动物保护区。酒店的外部用石头搭建，木头门窗，看起来很古老的样子，住在这家酒店最奇特的感觉，是每天早上会被狮子等野兽的叫声吵醒。\r\n\r\n　　我们去参观这些野生动物需要乘坐一种特殊的卡车，车的周围有铁栏杆保护，以防被动物袭击。这里的保护区大部分没有围栏，在里面可以看到南非小羚羊（跳羚）、长颈鹿、条纹鬣狗、狮子、猎豹等野生动物。其中猎豹给人的印象非常深刻，猎豹是所有大型猫科动物中最温顺的一种，一般不主动攻击人，易于驯养，身上有斑点，在双眼下面有黑点，称为泪痕。据南非祖鲁族传统故事说，猎豹的泪痕是因为猎人偷走了母猎豹的孩子后哭出来的。酒店的女主人绘声绘色地给我们讲述这个有趣的故事，我们忍不住去抚摸一下猎豹，通常情况下是没有什么危险的。\r\n\r\n\r\n\r\n　　约翰内斯堡：了解南非历史\r\n\r\n　　约翰内斯堡是我们到访南非的第二站，离比勒陀利亚很近，仅40分钟车程。如今的约翰内斯堡已经是南非第一大城市，也是世界上最大的产金中心，是一个由黄金开采而建立起来的大都市，被称作“黄金之都”，四通八达的高速公路网覆盖整个城市。\r\n\r\n　　在约翰内斯堡，我们有幸访问了南非2010世界杯组委会，组委会主席Rich Mkhondo在一间狭小无比的办公室接待了我们，他向我们介绍，世界杯的准备工作已经基本就绪，南非已经投入大量资金用于新建、改建体育场馆，为了改善南非的公共交通问题，还特意从韩国购买了几千辆豪华大巴，穿梭于各城区和比赛场馆之间，确保世界杯期间球迷和游客的运输。对于南非的治安问题，他表示南非犯罪率高的问题已经得到了很好控制，世界杯期间的安全将得到保证。\r\n\r\n　　要想对南非历史文化有更深刻的了解，在约翰内斯堡不能不去一个地方：南非种族隔离博物馆。\r\n\r\n\r\n\r\n　　南非种族隔离博物馆的入口有两道门，一道是白人进入的，一道是黑人的，每个入口都向我们展示了种族隔离时期不同种族的身份证，而这个身份证，就决定了一个人的命运，黑人只能在贫困、落后、肮脏的地方生活，而白人则享有特权，掌握政治经济的大权。\r\n\r\n　　博物馆里展示了很多有历史价值的史料和实物，包括种族隔离时期黑人受虐的照片、黑人当年悲惨生活的照片，还有按照原状复制的关押黑人犯人监狱的模型、警察抓捕黑人警车的模型，揭露了南非种族隔离时期的黑暗统治。\r\n\r\n　　为了反抗残酷统治，那些热爱平等、自由的黑人开始了艰苦卓绝的斗争，博物馆里播放了一部纪录片，详细描述了黑人的斗争历史，为了争取自由和权利，那些年轻的黑人纷纷走上街头，对白人统治者展开了斗争和反抗，纪录片的插曲非常好听，听得人热血澎湃，令人感动。\r\n\r\n　　开普敦：魅力花园城市\r\n\r\n　　如果说约翰内斯堡是南非的经济文化中心，那么开普敦就是南非的旅游中心，它是南非第二大城市，位于南非最南端，以其美丽的自然景观闻名于世，也是南非最漂亮最迷人的海滨城市。整个城市背山面海，风光绮丽，旅游业兴盛，工商业发达，有“小欧洲”之称。\r\n\r\n　　开普敦是个非常美丽的花园城市，有次我们去议会大厦旁边的Company Gardens花园里吃午饭，任何中国人来到这个花园都无法掩饰住自己的惊讶。这是一条满眼葱翠、鸟语花香和成群松鼠欢快嬉戏的林荫大道，到处都是鸽子、松鼠、鹅等动物，都不怕人。只要一举手，小动物们就会跑过来，鸽子就会飞过来，这在中国简直是不可能的。拿一些花生，就可以让可爱的小松鼠爬到你身上来吃东西，人与大自然的亲近到了这种地步，真如同梦境一样。\r\n\r\n　　桌山（Table Mountain）是开普敦最著名的景点，也是开普敦的地标，海拔一千多米，最大的特点是：山顶是平的，而且平展得如同一个巨大的桌面， 从山顶往下看，整个开普敦的市容一览无遗，景色绝佳。往北面的远处看，依稀可见我们住的酒店，以及繁华商业区Waterfront.在开普敦，无论站在任何地方，放眼望去，桌山就在你的眼前。', '2010-06-12 11:29:04', '2010-06-12 11:29:04'),
(12, 1, '苹果 vs 微软', '生活曾都可以防盗锁考虑后果卡，发送到哭一下我看了就二年，放到空间哦子发送旅客离开，风流快活考虑恐惧心理从，发动了空间更的脸色疯狂进攻哦啊。\r\n放松了卡及粉红色离开，fs阿fs\r\n风口浪尖累块积苏的烦恼名。庞维仁万恶可满足。\r\n法拉萨克警方很快立即恢复的 。', '2010-06-12 19:28:06', '2010-06-12 19:28:06'),
(14, 2, '世界杯', '韩国对居然领先了。。。\r\n搞毛阿。', '2010-06-12 19:51:55', '2010-06-12 19:51:55'),
(16, 2, '设置头像问题', '昨天你赢了我，昨天我输给了你，然而此时此刻，我们面对的还不是一样的日出。有些重要的东西并不特属于强者，比如阳光。早晨，各位..', '2010-06-14 16:33:48', '2010-06-14 16:33:48'),
(17, 2, '使用Nginx给Google App Engine做负载均衡', '<p>周末突发奇想&ldquo;能不能用nginx给自己的多个Google App Enine  （以下简称GAE）应用作负载均衡呢？&rdquo;想想蛮有意思的，动手试试看吧，不过这是我第一次用nginx做负载均衡，也是玩玩而已，我还没有那么大访问量的 应用。</p>\r\n<p>　　关于nginx的介绍，百度百科，维基百科和官网都能找到，国内的张晏写很了个很详细的用nignx  搭建Web服务器的教程-《Nginx + PHP  （FastCGI）搭建胜过Apache十倍的Web服务器》，也是得益于这个教程，我才顺利的在vps上用nginx搭建好了web服务器，在此表示感 谢。</p>\r\n<p>　　负载均衡听起来貌似很复杂，很深奥的技术，等你亲自尝试一番之后会发现：其实在nginx上配置比较简单。</p>\r\n<p>　　好 了，下面就进入到我们这个系统吧，我们要架构的整个系统的结构如下：</p>\r\n<p style="text-align: center;"><img src="http://www.williamlong.info/upload/2216_1.jpg" alt="用Nginx 给Google App Engine 做负载均衡" /></p>\r\n<p>　　步骤1.配置nginx 代理访问GAE应用</p>\r\n<p>　　首先，我们要配置多个代理（你有多少个GAE应用配额就可以设置多少个代理），直接通过IP访问GAE的应用是行不 通的，因为Google的服务器无法辨认是哪个应用，所以我们要使用nginx做代理，每个代理的配置方式如下：</p>\r\n<p>　　server</p>\r\n<p>　 　{</p>\r\n<p>　　listen 8081；</p>\r\n<p>　　location / {</p>\r\n<p>　　proxy_pass  http://app1.appspot.com；proxy_set_header&nbsp; Host&nbsp; &quot;app1.appspot.com&quot;；</p>\r\n<p>　 　proxy_set_header X-Real-IP $remote_addr；</p>\r\n<p>　　proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for；</p>\r\n<p>　　}</p>\r\n<p>　　&hellip;&hellip;</p>\r\n<p>　 　上面配置中设置主机头是关键配置，它应该设置为你GAE应用的原始域名，一般是xxx.appspot.com.当你重新nginx配置后，你将可以通 过8081端口访问你的GAE应用。</p>\r\n<p>　　步骤2.配置负载均衡</p>\r\n<p>　　nginx负载均衡是通过添加upstream{&hellip;&hellip;}配 置节来实现的，我配置了一个最简单的负载均衡方式：</p>\r\n<p>　　upstream backend</p>\r\n<p>　　{</p>\r\n<p>　　 server 127.0.0.1：8081；</p>\r\n<p>　　&hellip;&hellip;</p>\r\n<p>　　}</p>\r\n<p>　　可以看到，上面可以配置多个server字 段，因为在前面配置了多个代理，它们各自使用的端口不同。关于Server，据我所知有两种类型：</p>\r\n<p>　　1.每个Server的ip不同，开 始我给每个代理分配了一个域名，然后试图通过不同域名来区分server，失败了，这个还有待研究，有了解的朋友请不吝赐教。</p>\r\n<p>　　2.每个 Server的端口号不同，这个就是我们上面采取的方式了。</p>\r\n<p>　　Server除了配置地址参数外，还有其他很重要的参数，比如设置每个 Server的权重，是否为备份server等等，需要知道更详细的，建议看官方wiki.大家也可以尝试多种配置，做做实验嘛~~</p>\r\n<p>　　步 骤3.配置应用的总入口</p>\r\n<p>　　其他配置都准备就绪了，就差一个应用的入口点，也就是访问这个系统的域名，我的配置如下：</p>\r\n<p>　　 server {</p>\r\n<p>　　listen 80；</p>\r\n<p>　　server_name g.ooq.me；</p>\r\n<p>　　 location / {</p>\r\n<p>　　proxy_pass http://backend；</p>\r\n<p>　　proxy_set_header  Host $host；</p>\r\n<p>　　proxy_set_header X-Real-IP $remote_addr；</p>\r\n<p>　　 proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for；</p>\r\n<p>　　}</p>\r\n<p>　 　到这里所有的配置也就完了，重新加载一下nginx的配置文件，这个系统就启动了。</p>\r\n<p>　　小结</p>\r\n<p>　　搭建这个系统有诸多好处：</p>\r\n<p>　 　1.可以免费使用多个GAE跑一个应用。</p>\r\n<p>　　2.一个很好的学习nginx负载均衡的配置的实验环境。</p>\r\n<p>　　3.永远不用担 心GAE被封掉，只要确保你的vps能访问。</p>\r\n<p>　　缺点也是存在的：</p>\r\n<p>　　1.企业级的应用暂时是不可能的了，就算有也不用这么 麻烦，GAE本就是云计算应用，Google已经做了负载均衡，也就只能个人玩玩，做个博客什么的还是很好的选择。</p>\r\n<p>　　2.带宽的问题，我 的vps是在美国，ping了一下GAE的服务器只要6-8ms，还算是比较满意的，如果你的vps是在国内的话，估计速度会成问题。</p>\r\n<p>　　 3.数据库的共享是一个比较复杂的问题，如果每个GAE应用都用单独的数据库的话，那就不是一个系统了。迫切期待大家想出好的解决方式。</p>', '2010-06-14 16:35:00', '2010-06-21 14:07:00'),
(18, 2, '深入理解PHP之匿名函数', '<p>PHP中, 传递Callback的方式, 一直很丑陋. 在PHP5.3以前, 我们只有俩种选择:</p>\r\n<pre linenum="off" class="sh_bash" name="code"><ol><li>1. 字符串的函数名</li><li>2. 使用create_function的返回值</li></ol></pre>\r\n<p>在PHP5.3以后, 我们多了一个选择, 也就是Closure,</p>\r\n<pre linenum="off" class="sh_php sh_sourceCode" name="code"><ol><li><span class="sh_variable">$func</span> <span class="sh_symbol">=</span> <span class="sh_keyword">function</span> <span class="sh_symbol">()</span> <span class="sh_cbracket">{</span> <span class="sh_symbol">...</span> <span class="sh_cbracket">}</span><span class="sh_symbol">;</span></li><li><span class="sh_function">array_walk</span><span class="sh_symbol">(</span><span class="sh_variable">$arr</span><span class="sh_symbol">,</span> <span class="sh_variable">$func</span><span class="sh_symbol">);</span></li></ol></pre>\r\n<p>从实现上来说, 第一种方式: 传递函数名字符串是最简单的.</p>\r\n<p>而第二种方式create_function, 其实和第一种方式本质上一样的, create_function返回一个字符串的函数名,  这个函数名的格式是:</p>\r\n<pre linenum="off" class="sh_bash" name="code"><ol><li>&quot;\\000_lambda_&quot; . count(anonymous_functions)++;</li></ol></pre>\r\n<p>我们来看看create_function的实现步骤:</p>\r\n<pre linenum="off" class="sh_bash" name="code"><ol><li>1. 获取参数, 函数体</li><li>2. 拼凑一个&quot;function __lambda_func (参数) { 函数体;} &quot;的字符串</li><li>3. eval之</li><li>4. 通过__lambda_func在函数表中找到eval后得到的函数体, 找不到就出错</li><li>5. 定义一个函数名:&quot;\\000_lambda_&quot; . count(anonymous_functions)++</li><li>6. 用新的函数名替换__lambda_func</li><li>7. 返回新的函数名</li></ol></pre>\r\n<p>我们来验证下:</p>\r\n<pre linenum="off" class="sh_php sh_sourceCode" name="code"><ol><li><span class="sh_symbol">&lt;?php</span></li><li><span class="sh_function">create_function</span><span class="sh_symbol">(</span><span class="sh_string">&quot;&quot;</span><span class="sh_symbol">,</span> <span class="sh_string">''echo __FUNCTION__;''</span><span class="sh_symbol">);</span></li><li><span class="sh_function">call_user_func</span><span class="sh_symbol">(</span><span class="sh_string">&quot;\\000lambda_1&quot;</span><span class="sh_symbol">,</span> <span class="sh_number">1</span><span class="sh_symbol">);</span></li><li><span class="sh_symbol">?&gt;</span></li><li><span class="sh_comment">//输出</span></li><li>__lambda_func</li></ol></pre>\r\n<p>因为在eval的时候, 函数名是&rdquo;__lambda_func&rdquo;, 所以匿名函数内会输出__lambda_func,  而因为最后用&rdquo;\\000_lambda_&rdquo; .  count(anonymous_functions)++重命名了函数表中的&rdquo;__lambda_func&rdquo;函数,  所以可通过&rdquo;\\000_lambda_&rdquo; . count(anonymous_functions)++调用这个匿名函数.</p>\r\n<p>为了证实这一点, 可以将create_function的返回值dump出来查看.</p>\r\n<p>而在PHP5.3发布的时候, 其中有一条new feature就是支持闭包/Lambda Function,  我第一反应是以为zval新增了一个IS_FUNCTION, 但实际上是构造了一个PHP5.3引入的Closure&rdquo;类&rdquo;的实例,  Closure类的构造函数是私有的, 所以不能被直接实例化, 另外Closure类是Final类, 所以也不能做为基类派生子类.</p>\r\n<pre linenum="off" class="sh_php sh_sourceCode" name="code"><ol><li><span class="sh_comment">//php-5.3.0</span></li><li><span class="sh_variable">$class</span> <span class="sh_symbol">=</span> <span class="sh_keyword">new</span> <span class="sh_function">ReflectionClass</span><span class="sh_symbol">(</span><span class="sh_string">&quot;Closure&quot;</span><span class="sh_symbol">);</span></li><li><span class="sh_function">var_dump</span><span class="sh_symbol">(</span><span class="sh_variable">$class</span><span class="sh_symbol">-&gt;</span><span class="sh_function">isInternal</span><span class="sh_symbol">());</span></li><li><span class="sh_function">var_dump</span><span class="sh_symbol">(</span><span class="sh_variable">$class</span><span class="sh_symbol">-&gt;</span><span class="sh_function">isAbstract</span><span class="sh_symbol">()</span> <span class="sh_symbol">);</span></li><li><span class="sh_function">var_dump</span><span class="sh_symbol">(</span><span class="sh_variable">$class</span><span class="sh_symbol">-&gt;</span><span class="sh_function">isFinal</span><span class="sh_symbol">());</span></li><li><span class="sh_function">var_dump</span><span class="sh_symbol">(</span><span class="sh_variable">$class</span><span class="sh_symbol">-&gt;</span><span class="sh_function">isInterface</span><span class="sh_symbol">());</span></li><li><span class="sh_comment">//输出:</span></li><li><span class="sh_function">bool</span><span class="sh_symbol">(</span>true<span class="sh_symbol">)</span></li><li><span class="sh_function">bool</span><span class="sh_symbol">(</span>false<span class="sh_symbol">)</span></li><li><span class="sh_function">bool</span><span class="sh_symbol">(</span>true<span class="sh_symbol">)</span></li><li><span class="sh_function">bool</span><span class="sh_symbol">(</span>false<span class="sh_symbol">)</span></li><li><span class="sh_symbol">?&gt;</span></li></ol></pre>\r\n<p>而PHP5.3中对闭包的支持, 也仅仅是把要保持的外部变量,  做为Closure对象的&rdquo;Static属性&rdquo;(并不是普通意义上的可遍历/访问的属性).</p>\r\n<pre linenum="off" class="sh_php sh_sourceCode" name="code"><ol><li><span class="sh_comment">//php-5.3.0</span></li><li><span class="sh_variable">$b</span> <span class="sh_symbol">=</span> <span class="sh_string">&quot;laruence&quot;</span><span class="sh_symbol">;</span></li><li><span class="sh_variable">$func</span> <span class="sh_symbol">=</span> <span class="sh_keyword">function</span><span class="sh_symbol">(</span><span class="sh_variable">$a</span><span class="sh_symbol">)</span> <span class="sh_keyword">use</span><span class="sh_symbol">(</span><span class="sh_variable">$b</span><span class="sh_symbol">)</span> <span class="sh_cbracket">{}</span><span class="sh_symbol">;</span></li><li><span class="sh_function">var_dump</span><span class="sh_symbol">(</span><span class="sh_variable">$func</span><span class="sh_symbol">);</span></li><li><span class="sh_comment">/* 输出:</span></li><li><span class="sh_comment">object(Closure)#1 (2) {</span></li><li><span class="sh_comment">  [&quot;static&quot;]=&gt;</span></li><li><span class="sh_comment">  array(1) {</span></li><li><span class="sh_comment">    [&quot;b&quot;]=&gt;</span></li><li><span class="sh_comment">    string(8) &quot;laruence&quot;</span></li><li><span class="sh_comment">  }</span></li><li><span class="sh_comment">  [&quot;parameter&quot;]=&gt;</span></li><li><span class="sh_comment">  array(1) {</span></li><li><span class="sh_comment">    [&quot;$a&quot;]=&gt;</span></li><li><span class="sh_comment">    string(10) &quot;&lt;required&gt;&quot;</span></li><li><span class="sh_comment">  }</span></li><li><span class="sh_comment">}</span></li><li><span class="sh_comment">*/</span></li></ol></pre>\r\n<p>这个实现, 个人认为和JS对闭包的支持比起来, 还是有些太简陋了~</p>', '2010-06-14 16:35:29', '2010-06-21 14:05:50'),
(19, 3, ' DictUnifier – 添加系统词典 [Mac] ', '<div class="entry-content">\r\n<p>Mac 系统已经自带了字典程序 Dictionary，且和自家 Safari、Mail、SpotLight  等程序高度整合。遗憾的是，任二狗却对英英字典没有什么兴趣。自然，他最需要的是英汉汉英词典。能不能自行添加词典到系统的词典程序呢？答案自然是可以， 不过需要软件辅助。<a href="http://www.appinn.com/dictunifier/"><strong>DictUnifier</strong></a>  就是国人出品的一款词典转换软件，可以自动转换安装<a href="http://stardict.sourceforge.net/">星际译王  (StarDict)</a> 格式字典，自动添加到 Mac 自带字典程序。@appinn</p>\r\n<div align="center"><a href="http://www.appinn.com/dictunifier/"><img title="DictUnifier\r\n添加系统词典 [Mac][图] | 小众软件 &gt; mac" alt="DictUnifier   添加系统词典 [Mac][图] | 小众软件 &gt; mac" src="http://img1.appinn.com/2010/06/DictUnifier-20100621-022407.jpg" /></a></div>\r\n<p><strong>词典添加步骤</strong></p>\r\n<p>&nbsp;</p>\r\n<ol>\r\n    <li>在<a href="http://www.huzheng.org/stardict-iso/stardict-dic/">此链接</a>下 载需要的星际译王格式词典，若对文件名不解，参考<a href="http://stardict.sourceforge.net/Dictionaries_zh_CN.php">此页面</a>（该页 面下载链接失效）。</li>\r\n    <li>下载 <strong>DictUnifier</strong> 软件</li>\r\n    <li>打开 <strong>DictUnifier</strong> 软件，将需要安装的字典文件拖入 <strong>DictUnifier</strong>  窗口（这操作简单到令人发指）</li>\r\n    <li>等待转换安装完成。这会需要很长时间，少则十几分钟，多则几个小时，取决于字典大小。</li>\r\n</ol>\r\n<div align="center"><img title="DictUnifier   添加系统词典 [Mac][图] | 小众软件 &gt; mac" alt="Dcit" src="http://img1.appinn.com/2010/06/dictUnifier-20100621-025045.jpg" /></div>\r\n<p>本质上，<strong>DictUnifier</strong> 做了两件事：首先转换字典格式成 .dictionary  文件，成功后自动将文件复制到 {用户名}/Library/Dictionaries  目录。若不需要转换的字典，直接去目录下删除文件即可。自然，别忘了在字典程序的偏好设置里面，调整词典顺序，禁用不需要的词典。</p>\r\n<p><img alt="小众软件下载" src="http://www.appinn.com/wp-content/down.gif" title="点击右侧的链接下载本软件" class="imgdown" /> 下载(0.9  MB): <a href="http://g.appinn.com/bx">uushare</a> | <a href="http://code.google.com/p/mac-dictionary-kit/">官方网站</a> | <a href="http://www.appinn.com/dictunifier/">来自小众软件</a></p>\r\n</div>', '2010-06-14 16:40:55', '2010-06-21 13:45:17'),
(22, 1, '在JSP中forward和redirect的实例应用', '绝对路径与相对路径\r\n如果咱们使用的URL网址是以“/”开头的，那么这个网址就叫做绝对路径。\r\n如果咱们使用的URL网址不是“/”开头的，那么这个网址就叫做相对路径。\r\n', '2010-06-14 16:51:49', '2010-06-14 16:51:49'),
(23, 3, '在JSF/JSP中集成 FCKEditor 2.6', '<p>目前，FCKEditor (<a href="http://www.fckeditor.net/">http://www.fckeditor.net/</a>)  是开源社区一款强大的HTML编辑器，目前最新版本是2.6，支持Java的插件版本是2.4Beta1。</p>\r\n<p>&nbsp;</p>\r\n<p>对于一般的Java  Web应用，我们可以通过直接插入JavaScript代码来构造页面，这种方式操作起来比较简便，也是通用在所有web页面的一种方式。但是，在实际的 Java  Web应用中，我们除了用到普通的页面编辑功能之外，难免会考虑到页面上传图片、附件等功能。所以，单纯使用JavaScript方式的话，这一大堆的文 件上传代码将由你自己来写了，工程量还是比较浩大的。自然而然，我们会想到Jsp  Tag，有没有现成的快餐式的页面标签呢？答案是肯定的，就如我上文提到的Java插件就已经实现了这些功能，并集成了Apache  Commons-FileUpload，以此来实现文件服务器上传。</p>', '2010-06-20 22:57:17', '2010-06-20 23:08:50'),
(24, 3, '[来自异次元] PHP、jQuery、CSS、HTML等Web开发参考手册CHM文档中文版下载', '<p>做WEB编程或者<a href="http://www.iplaysoft.com/web-develop-chm.html">学习WEB 开发</a>的朋友可能经常会遇到，遇到一些印象不太深的函数会经常忘记用法或者拼写。平时的话Google或百度一下就OK了，但是当你处在上网不便的 地方而又需要工作的时候，一些小小的问题就会卡住你的进度了。</p>\r\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 最近X-Force在做新的PHP项目时就遇到了这样的问题，用3G上网太贵了，查一点东西就上网也挺麻烦的。于是干脆把PHP相关的<a href="http://www.iplaysoft.com/web-develop-chm.html">WEB开发文档</a>都全收集起来， 方便离线时查询。这次收集的有<strong>PHP</strong>、CSS、jQuery、Javascript、MySQL、正则表达式、CSS 和CSS3，希望对大家有帮助吧&hellip;&hellip;</p>\r\n<h3>关于文档格式：</h3>\r\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 为了方便搜索查询，本次收集的<a href="http://www.iplaysoft.com/web-develop-chm.html">开发参考文档</a>都是CHM格式，支 持索引和离线本地搜索，而收集的应该都是目前我能找到的最新版本的文档了。</p>\r\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 一些朋友可能会遇到打开CHM后显示&ldquo;取消操作&rdquo;等不能显示的问题，大家可以参考这篇文章解决：<a target="_blank" href="http://www.iplaysoft.com/solve-chm-viewing-problem.html">最简单解决CHM文件无法显示的办法</a></p>\r\n<p align="center"><img width="500" height="360" border="0" src="http://img.iplaysoft.com/wp-content/uploads/2010/PHPjQueryCSSHTMLWebCHM_FF04/2.jpg" alt="Web开发相关参考手册CHM文档" title="Web开发相关参考手册CHM文档" style="border-width: 0px; display: block; float: none; margin-left: auto; margin-right: auto;" />&nbsp;<a href="http://www.iplaysoft.com/web-develop-chm.html">PHP中文参考手册CHM文档</a>截 图</p>', '2010-06-21 13:39:43', '2010-06-21 13:39:43'),
(25, 4, '4个简单好用的在线笔记本网站 (云记事本)', '<ins style="display: inline-table; border: medium none; height: 280px; margin: 0pt; padding: 0pt; position: relative; visibility: visible; width: 336px;"><ins style="display: block; border: medium none; height: 280px; margin: 0pt; padding: 0pt; position: relative; visibility: visible; width: 336px;"><iframe width="336" height="280" frameborder="0" scrolling="no" allowtransparency="true" hspace="0" id="google_ads_frame1" marginheight="0" marginwidth="0" name="google_ads_frame" src="http://googleads.g.doubleclick.net/pagead/ads?client=ca-pub-2416009819532368&amp;output=html&amp;h=280&amp;slotname=0211475860&amp;w=336&amp;lmt=1277097482&amp;flash=10.0.45&amp;url=http%3A%2F%2Fwww.ipc.me%2F4-web-notepad.html&amp;dt=1277100926731&amp;shv=r20100607&amp;correlator=1277100926737&amp;frm=0&amp;adk=1202578712&amp;ga_vid=1120465015.1271308371&amp;ga_sid=1277100927&amp;ga_hid=845640708&amp;ga_fc=1&amp;ga_wpids=UA-3205969-9&amp;u_tz=480&amp;u_his=1&amp;u_java=0&amp;u_h=800&amp;u_w=1280&amp;u_ah=750&amp;u_aw=1280&amp;u_cd=24&amp;u_nplug=7&amp;u_nmime=42&amp;biw=1278&amp;bih=606&amp;ref=http%3A%2F%2Fwww.google.com%2Freader%2Fview%2F&amp;fu=0&amp;ifi=1&amp;dtd=294&amp;xpc=UTXdnxa6B7&amp;p=http%3A//www.ipc.me" style="left: 0pt; position: absolute; top: 0pt;" vspace="0"></iframe></ins></ins><center> </center>\r\n<div class="post_content">\r\n<p>这里给大家介绍<a href="http://www.ipc.me/4-web-notepad.html">4个免费的在线笔记本服务</a>(云 笔记本)，仅限于简单的文字编辑，不像google docs, zoho之类的在线办公系统，没有富文本编辑功能，但它们却相当的方便&hellip;&hellip;</p>\r\n<p><a href="http://www.ipc.me/4-web-notepad.html"><img width="450" height="250" border="0" style="border-width: 0px; display: block; float: none; margin-left: auto; margin-right: auto;" title="4个免费的在线笔记本服务" alt="4个免费的在线笔记本服务" src="http://img.ipc.me/uploads/2010/img/4_11140/1.jpg" /></a></p>\r\n<p><strong>云笔记本</strong> <a href="http://notepad.cc/">http://notepad.cc/</a></p>\r\n<p>极简洁, 它甚至没有主页, logo, 没有about 页面, 而它实现的功能, 完全符合以前我设想过的一款在线笔记本的全部构思.  输入或粘贴文字内容到一个大大的文本框里, 通过随机生成的网址访问,&nbsp; 可以设置访问密码.    <br />\r\n超出我预期的功能有:分享网址有两种,  一种是不可编辑的, 像这样 <a href="http://notepad.cc/share/xPSC4MeLMC">http://notepad.cc/share/xPSC4MeLMC</a>,  一种是可编辑的 (最初访问量分配的网址)<a href="http://notepad.cc/nanfang">http://notepad.cc/nanfang</a>  ; 可编辑的地址是可以自定义的.     <br />\r\n还有一些包括注册管理, 访问统计,&nbsp; 版本修订记录等功能是否添加, 就看网站自己的定位了.  不用注册, 其实也可以通过文档访问地址的自定义规则加密码访问来实现管理, 自定义url 可以带 &ldquo;-&rdquo;的.</p>\r\n<p>===============</p>\r\n<p><strong>易贴</strong> <a href="http://1tie.me/">http://1tie.me</a></p>\r\n<p>超级简单的中文在线笔记服务,注册无需邮箱验证,5秒搞定. 注册后你会得到 <a href="http://1tie.me/username">http://1tie.me/username</a>  的个人笔记本地址．[以前的1tie.cn域名给停用了]     <br />\r\n此笔记本真的就只能码字了，像信纸一样的页面让人写起来感觉不错．     <br />\r\n你 的笔记可以设为私密，其他人要查看必须输入密码．     <br />\r\n通过访问你的笔记本地址，任何人可以至少看到你的笔记标题．     <br />\r\n所有笔 记可以方便的备份到你的预留邮箱里．     <br />\r\n易贴的其它服务，如相册，视频，网址收藏等已停止，团队正专注于提供更好的笔记服务．     <br />\r\n它 真的很简单！</p>\r\n<p>===============</p>\r\n<p><strong>阅后即焚</strong> <a href="https://privnote.com/">https://privnote.com/</a></p>\r\n<p>也是很简单的在线文本信息传递服务, 简单三步说明其功能:  创建新便签并得到链接-&gt;复制链接然后发送给您想让他阅读的人-&gt;便签在被阅读后会自动销毁.&nbsp; 你可以留下自己的邮箱,  以接收便签被阅读(访问)的通知.    <br />\r\n我觉得这个服务加上短网址服务[http://sfs.im]会更方便,  因为生成的随机链接是比较长的.</p>\r\n<p>===============</p>\r\n<p><strong>协同笔记</strong> <a href="http://piratepad.net/">http://piratepad.net/</a></p>\r\n<p>这是我之前介绍过的了, 多人同时编辑一个<a href="http://www.ipc.me/4-web-notepad.html">文本 文档</a>, 实时更新. 便于分享, 但没密码保护. 侧重于协同工作, 带revision 和timeline功能。</p>\r\n</div>', '2010-06-21 14:15:59', '2010-06-21 15:36:14');

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `comment_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `comment_blog_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `comment_user_id` bigint(20) DEFAULT '0',
  `comment_content` text NOT NULL,
  `comment_date` datetime NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `comment_ibfk_1` (`comment_blog_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=43 ;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`comment_id`, `comment_blog_id`, `comment_user_id`, `comment_content`, `comment_date`) VALUES
(2, 10, 1, '为胜利而战！飞洒会计分录撒谎；jksdfjkslk发送旅客积分卡溯端竟委而莪\r\n儿哦题i', '2010-06-14 17:41:06'),
(3, 22, 0, '沙发！', '2010-06-14 23:00:21'),
(4, 22, 2, '抢我沙发！', '2010-06-14 23:00:47'),
(5, 16, 0, 'facebook and rss', '2010-06-17 15:33:00'),
(6, 16, 0, '什么玩意  不知道 这时怎么会是 \r\n先仰头，向左右旋转，如果你觉得有些酸痛，基本可以确定已经有重复性损伤造成的颈椎问题。', '2010-06-17 15:34:12'),
(7, 16, 0, '（重复性劳损伤害）。软件 AntiRSI  通过定时提示休', '2010-06-17 15:34:24'),
(8, 16, 0, '除了定时强制几分钟的大休，几十秒的小憩，它还能自动检测用户的自然休息，不会过多强制。', '2010-06-17 15:34:36'),
(9, 16, 0, 'iPhone 4 像恒星湮灭一样的光环使得很多人忘记了 Safari 5 的出现', '2010-06-17 15:35:03'),
(10, 16, 2, '越来越多的同学开始逐步把域名和主机迁移到墙外蜗居，低价格高品质的服务也只有墙外有。\r\n\r\n那你可能经常搜索各类域名注册续费、主机购买的优惠码。例如 Godaddy、BlueHost、Name.com 等等诸如此类的服务商。', '2010-06-17 15:37:49'),
(11, 16, 2, '在用户表单中，你可能希望移除所有不必要的 HTML 标记。使用 strip_tags() 函数可以简单地做到这一点：', '2010-06-17 15:38:17'),
(12, 16, 2, '大家都知道，Twitter  仅仅接受 140 字符以内的消息。如果你希望与这个流行的即时信息网站交互，肯定会喜欢这个功能，这将允许对留言截断为 140 个字符。\r\n\r\n', '2010-06-17 15:38:48'),
(13, 16, 2, '五月底的传言还是被证实了，马化腾终于决定出手了。“腾讯收购康盛创想，已经谈成，不是传言中的入股、战略投资，而是通过现金加股权的方式达成收购，价格也比传言中的1000万美元高，大约在几千万美元，具体数额不方便透露。”6月14日，互联网业内知情人士对时代周报记者如此说道。', '2010-06-17 15:39:14'),
(14, 16, 2, '如此这般，在康盛被腾讯收购的信息被证实后，接下来，你将会看到更多的财富通的信息，和中小合作的计划，在资费上，财会通目前还是免费的模式，如此很多人就会优先考虑财富通的，所以财富通的发展还是有很大空间的，尤其是今年如此关键的电子商务一年中，将会看到真正的电子支付工具哪家占上风，更让人熟知。', '2010-06-17 15:39:40'),
(15, 22, 2, '重要吗？\r\n', '2010-06-17 15:41:17'),
(16, 22, 3, '我也要评论', '2010-06-17 15:42:34'),
(17, 16, 3, '这是谁写的文章， 这么短', '2010-06-17 15:43:25'),
(18, 16, 3, '你管这么多做甚', '2010-06-17 15:43:57'),
(19, 23, 3, '哪里ds ', '2010-06-20 23:01:01'),
(20, 5, 3, '这时什么', '2010-06-20 23:27:33'),
(21, 5, 3, '这时什么', '2010-06-20 23:28:23'),
(22, 5, 3, '这时什么', '2010-06-20 23:30:33'),
(23, 23, 0, '这时什么客流有防盗萨', '2010-06-21 11:08:17'),
(24, 23, 0, '11111', '2010-06-21 11:08:29'),
(25, 23, 0, '2222222', '2010-06-21 11:08:34'),
(26, 23, 0, '434423346546', '2010-06-21 11:08:38'),
(27, 23, 0, '243546357566', '2010-06-21 11:08:43'),
(28, 18, 0, '尾页来看看', '2010-06-21 11:23:00'),
(29, 18, 0, '<p>用fck写的评论！</p>', '2010-06-21 13:08:23'),
(30, 18, 0, '', '2010-06-21 13:08:44'),
(31, 18, 0, '<p>小方纱布</p>', '2010-06-21 13:12:14'),
(33, 18, 0, '<p>曾经。。。</p>', '2010-06-21 13:31:37'),
(34, 24, 3, '<p>nice 正好需要</p>', '2010-06-21 13:40:52'),
(35, 17, 4, '<p>发动了卡及弗兰克斯电话</p>', '2010-06-21 14:13:44'),
(36, 24, 0, '<p>这到底什么！！！</p>', '2010-06-21 15:17:26'),
(37, 25, 0, '<p>第一条评论</p>', '2010-06-21 15:34:50'),
(38, 19, 0, '<p>居然没有评论</p>', '2010-06-21 15:37:48'),
(39, 22, 0, '<p><em>我来也！</em></p>', '2010-06-21 16:03:24'),
(40, 22, 0, '<p><strong>我也来也！</strong></p>', '2010-06-21 16:03:52'),
(41, 22, 0, '<p>着什么空</p>', '2010-06-22 13:11:23'),
(42, 18, 0, '<p>物语啊啊啊啊</p>', '2010-06-22 15:47:42');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_nickname` varchar(50) NOT NULL,
  `user_motto` varchar(255) DEFAULT NULL,
  `user_level` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_password`, `user_nickname`, `user_motto`, `user_level`) VALUES
(1, '汤文杰', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2', '无所畏惧', '																这个世界上没有什么可畏惧的。						\r\n							\r\n							', 0),
(2, '何足道', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', '辅导课支柱', '立刻就回滚', 1),
(3, 'hezudaopp', '6216f8a75fd5bb3d5f22b6f9958cdede3fc086c2', 'pp 品牌', '何足道哉\r\n											', 0),
(4, 'blog', '169254c45fa4ed7ea11c00541ffb17b0cde39625', 'blog', 'blog', 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `blog`
--
ALTER TABLE `blog`
  ADD CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`blog_user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`comment_blog_id`) REFERENCES `blog` (`blog_id`) ON DELETE CASCADE ON UPDATE CASCADE;

SET FOREIGN_KEY_CHECKS=1;
