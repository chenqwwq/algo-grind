# ⚡ algo-grind

> **One problem, multiple languages. Zero excuses.**

Multi-language algorithm playground — Java ☕ · C++ 🔷 · Go 🐹
Solutions for LeetCode Daily / Weekly / Biweekly contests and interview prep.
Auto-tracked progress, auto-updated README.

## 📊 刷题进度

<!-- PROGRESS:START -->
> 自动统计当前活跃题解目录，最近更新：2026/09/13

| 🧭 总览 | 数量 |
| --- | ---: |
| 题目目录 | 187 |

### 🗂️ 按分类

| 分类 | 题目目录 |
| --- | ---: |
| 📅 LeetCode Daily | 78 |
| 🏁 LeetCode Weekly | 77 |
| ⚡ LeetCode Biweekly | 30 |
| 💼 Interview | 2 |

### 🧪 按语言

| 语言 | 题目目录 |
| --- | ---: |
| ☕ Java | 182 |
| 🔷 C++ | 4 |
| 🐹 Go | 1 |
<!-- PROGRESS:END -->

## 目录约定

```text
src/
  java/              # Java 当前题目和模板，Maven sourceDirectory
  cpp/               # C++ 当前题目和模板，CMake 默认扫描
  go/                # Go 当前题目和模板
  include/           # C/C++ 公共 include
docs/
  templates/algorithm # 模板说明文档
```

## 🛠️ 题解目录生成

`scripts/lc` 用于快速生成题解目录与 `Solution.java` 骨架，在仓库根目录执行：

```bash
lc -d           # 日常刷题，生成 daily/_<年>/_<当天日期>
lc -w 518       # 周赛，生成 contest/weekly/_518/_1 ~ _4
lc -bw 190      # 双周赛，生成 contest/biweek/_190/_1 ~ _4
```

已存在的 `Solution.java` 会被跳过，不会覆盖。

本机安装：`ln -sf "$PWD/scripts/lc" ~/bin/lc`，并确保 `~/bin` 在 `PATH` 中。
