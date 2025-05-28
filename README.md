# BE10-1st-3team
첫번째 팀프로젝트
<html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8"/><title> first. 영화관 예매 관리</title><style>
/* cspell:disable-file */
/* webkit printing magic: print all background colors */
html {
	-webkit-print-color-adjust: exact;
}
* {
	box-sizing: border-box;
	-webkit-print-color-adjust: exact;
}

html,
body {
	margin: 0;
	padding: 0;
}
@media only screen {
	body {
		margin: 2em auto;
		max-width: 900px;
		color: rgb(55, 53, 47);
	}
}

body {
	line-height: 1.5;
	white-space: pre-wrap;
}

a,
a.visited {
	color: inherit;
	text-decoration: underline;
}

.pdf-relative-link-path {
	font-size: 80%;
	color: #444;
}

h1,
h2,
h3 {
	letter-spacing: -0.01em;
	line-height: 1.2;
	font-weight: 600;
	margin-bottom: 0;
}

.page-title {
	font-size: 2.5rem;
	font-weight: 700;
	margin-top: 0;
	margin-bottom: 0.75em;
}

h1 {
	font-size: 1.875rem;
	margin-top: 1.875rem;
}

h2 {
	font-size: 1.5rem;
	margin-top: 1.5rem;
}

h3 {
	font-size: 1.25rem;
	margin-top: 1.25rem;
}

.source {
	border: 1px solid #ddd;
	border-radius: 3px;
	padding: 1.5em;
	word-break: break-all;
}

.callout {
	border-radius: 3px;
	padding: 1rem;
}

figure {
	margin: 1.25em 0;
	page-break-inside: avoid;
}

figcaption {
	opacity: 0.5;
	font-size: 85%;
	margin-top: 0.5em;
}

mark {
	background-color: transparent;
}

.indented {
	padding-left: 1.5em;
}

hr {
	background: transparent;
	display: block;
	width: 100%;
	height: 1px;
	visibility: visible;
	border: none;
	border-bottom: 1px solid rgba(55, 53, 47, 0.09);
}

img {
	max-width: 100%;
}

@media only print {
	img {
		max-height: 100vh;
		object-fit: contain;
	}
}

@page {
	margin: 1in;
}

.collection-content {
	font-size: 0.875rem;
}

.column-list {
	display: flex;
	justify-content: space-between;
}

.column {
	padding: 0 1em;
}

.column:first-child {
	padding-left: 0;
}

.column:last-child {
	padding-right: 0;
}

.table_of_contents-item {
	display: block;
	font-size: 0.875rem;
	line-height: 1.3;
	padding: 0.125rem;
}

.table_of_contents-indent-1 {
	margin-left: 1.5rem;
}

.table_of_contents-indent-2 {
	margin-left: 3rem;
}

.table_of_contents-indent-3 {
	margin-left: 4.5rem;
}

.table_of_contents-link {
	text-decoration: none;
	opacity: 0.7;
	border-bottom: 1px solid rgba(55, 53, 47, 0.18);
}

table,
th,
td {
	border: 1px solid rgba(55, 53, 47, 0.09);
	border-collapse: collapse;
}

table {
	border-left: none;
	border-right: none;
}

th,
td {
	font-weight: normal;
	padding: 0.25em 0.5em;
	line-height: 1.5;
	min-height: 1.5em;
	text-align: left;
}

th {
	color: rgba(55, 53, 47, 0.6);
}

ol,
ul {
	margin: 0;
	margin-block-start: 0.6em;
	margin-block-end: 0.6em;
}

li > ol:first-child,
li > ul:first-child {
	margin-block-start: 0.6em;
}

ul > li {
	list-style: disc;
}

ul.to-do-list {
	padding-inline-start: 0;
}

ul.to-do-list > li {
	list-style: none;
}

.to-do-children-checked {
	text-decoration: line-through;
	opacity: 0.375;
}

ul.toggle > li {
	list-style: none;
}

ul {
	padding-inline-start: 1.7em;
}

ul > li {
	padding-left: 0.1em;
}

ol {
	padding-inline-start: 1.6em;
}

ol > li {
	padding-left: 0.2em;
}

.mono ol {
	padding-inline-start: 2em;
}

.mono ol > li {
	text-indent: -0.4em;
}

.toggle {
	padding-inline-start: 0em;
	list-style-type: none;
}

/* Indent toggle children */
.toggle > li > details {
	padding-left: 1.7em;
}

.toggle > li > details > summary {
	margin-left: -1.1em;
}

.selected-value {
	display: inline-block;
	padding: 0 0.5em;
	background: rgba(206, 205, 202, 0.5);
	border-radius: 3px;
	margin-right: 0.5em;
	margin-top: 0.3em;
	margin-bottom: 0.3em;
	white-space: nowrap;
}

.collection-title {
	display: inline-block;
	margin-right: 1em;
}

.page-description {
	margin-bottom: 2em;
}

.simple-table {
	margin-top: 1em;
	font-size: 0.875rem;
	empty-cells: show;
}
.simple-table td {
	height: 29px;
	min-width: 120px;
}

.simple-table th {
	height: 29px;
	min-width: 120px;
}

.simple-table-header-color {
	background: rgb(247, 246, 243);
	color: black;
}
.simple-table-header {
	font-weight: 500;
}

time {
	opacity: 0.5;
}

.icon {
	display: inline-block;
	max-width: 1.2em;
	max-height: 1.2em;
	text-decoration: none;
	vertical-align: text-bottom;
	margin-right: 0.5em;
}

img.icon {
	border-radius: 3px;
}

.user-icon {
	width: 1.5em;
	height: 1.5em;
	border-radius: 100%;
	margin-right: 0.5rem;
}

.user-icon-inner {
	font-size: 0.8em;
}

.text-icon {
	border: 1px solid #000;
	text-align: center;
}

.page-cover-image {
	display: block;
	object-fit: cover;
	width: 100%;
	max-height: 30vh;
}

.page-header-icon {
	font-size: 3rem;
	margin-bottom: 1rem;
}

.page-header-icon-with-cover {
	margin-top: -0.72em;
	margin-left: 0.07em;
}

.page-header-icon img {
	border-radius: 3px;
}

.link-to-page {
	margin: 1em 0;
	padding: 0;
	border: none;
	font-weight: 500;
}

p > .user {
	opacity: 0.5;
}

td > .user,
td > time {
	white-space: nowrap;
}

input[type="checkbox"] {
	transform: scale(1.5);
	margin-right: 0.6em;
	vertical-align: middle;
}

p {
	margin-top: 0.5em;
	margin-bottom: 0.5em;
}

.image {
	border: none;
	margin: 1.5em 0;
	padding: 0;
	border-radius: 0;
	text-align: center;
}

.code,
code {
	background: rgba(135, 131, 120, 0.15);
	border-radius: 3px;
	padding: 0.2em 0.4em;
	border-radius: 3px;
	font-size: 85%;
	tab-size: 2;
}

code {
	color: #eb5757;
}

.code {
	padding: 1.5em 1em;
}

.code-wrap {
	white-space: pre-wrap;
	word-break: break-all;
}

.code > code {
	background: none;
	padding: 0;
	font-size: 100%;
	color: inherit;
}

blockquote {
	font-size: 1.25em;
	margin: 1em 0;
	padding-left: 1em;
	border-left: 3px solid rgb(55, 53, 47);
}

.bookmark {
	text-decoration: none;
	max-height: 8em;
	padding: 0;
	display: flex;
	width: 100%;
	align-items: stretch;
}

.bookmark-title {
	font-size: 0.85em;
	overflow: hidden;
	text-overflow: ellipsis;
	height: 1.75em;
	white-space: nowrap;
}

.bookmark-text {
	display: flex;
	flex-direction: column;
}

.bookmark-info {
	flex: 4 1 180px;
	padding: 12px 14px 14px;
	display: flex;
	flex-direction: column;
	justify-content: space-between;
}

.bookmark-image {
	width: 33%;
	flex: 1 1 180px;
	display: block;
	position: relative;
	object-fit: cover;
	border-radius: 1px;
}

.bookmark-description {
	color: rgba(55, 53, 47, 0.6);
	font-size: 0.75em;
	overflow: hidden;
	max-height: 4.5em;
	word-break: break-word;
}

.bookmark-href {
	font-size: 0.75em;
	margin-top: 0.25em;
}

.sans { font-family: ui-sans-serif, -apple-system, BlinkMacSystemFont, "Segoe UI Variable Display", "Segoe UI", Helvetica, "Apple Color Emoji", Arial, sans-serif, "Segoe UI Emoji", "Segoe UI Symbol"; }
.code { font-family: "SFMono-Regular", Menlo, Consolas, "PT Mono", "Liberation Mono", Courier, monospace; }
.serif { font-family: Lyon-Text, Georgia, ui-serif, serif; }
.mono { font-family: iawriter-mono, Nitti, Menlo, Courier, monospace; }
.pdf .sans { font-family: Inter, ui-sans-serif, -apple-system, BlinkMacSystemFont, "Segoe UI Variable Display", "Segoe UI", Helvetica, "Apple Color Emoji", Arial, sans-serif, "Segoe UI Emoji", "Segoe UI Symbol", 'Twemoji', 'Noto Color Emoji', 'Noto Sans CJK JP'; }
.pdf:lang(zh-CN) .sans { font-family: Inter, ui-sans-serif, -apple-system, BlinkMacSystemFont, "Segoe UI Variable Display", "Segoe UI", Helvetica, "Apple Color Emoji", Arial, sans-serif, "Segoe UI Emoji", "Segoe UI Symbol", 'Twemoji', 'Noto Color Emoji', 'Noto Sans CJK SC'; }
.pdf:lang(zh-TW) .sans { font-family: Inter, ui-sans-serif, -apple-system, BlinkMacSystemFont, "Segoe UI Variable Display", "Segoe UI", Helvetica, "Apple Color Emoji", Arial, sans-serif, "Segoe UI Emoji", "Segoe UI Symbol", 'Twemoji', 'Noto Color Emoji', 'Noto Sans CJK TC'; }
.pdf:lang(ko-KR) .sans { font-family: Inter, ui-sans-serif, -apple-system, BlinkMacSystemFont, "Segoe UI Variable Display", "Segoe UI", Helvetica, "Apple Color Emoji", Arial, sans-serif, "Segoe UI Emoji", "Segoe UI Symbol", 'Twemoji', 'Noto Color Emoji', 'Noto Sans CJK KR'; }
.pdf .code { font-family: Source Code Pro, "SFMono-Regular", Menlo, Consolas, "PT Mono", "Liberation Mono", Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK JP'; }
.pdf:lang(zh-CN) .code { font-family: Source Code Pro, "SFMono-Regular", Menlo, Consolas, "PT Mono", "Liberation Mono", Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK SC'; }
.pdf:lang(zh-TW) .code { font-family: Source Code Pro, "SFMono-Regular", Menlo, Consolas, "PT Mono", "Liberation Mono", Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK TC'; }
.pdf:lang(ko-KR) .code { font-family: Source Code Pro, "SFMono-Regular", Menlo, Consolas, "PT Mono", "Liberation Mono", Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK KR'; }
.pdf .serif { font-family: PT Serif, Lyon-Text, Georgia, ui-serif, serif, 'Twemoji', 'Noto Color Emoji', 'Noto Serif CJK JP'; }
.pdf:lang(zh-CN) .serif { font-family: PT Serif, Lyon-Text, Georgia, ui-serif, serif, 'Twemoji', 'Noto Color Emoji', 'Noto Serif CJK SC'; }
.pdf:lang(zh-TW) .serif { font-family: PT Serif, Lyon-Text, Georgia, ui-serif, serif, 'Twemoji', 'Noto Color Emoji', 'Noto Serif CJK TC'; }
.pdf:lang(ko-KR) .serif { font-family: PT Serif, Lyon-Text, Georgia, ui-serif, serif, 'Twemoji', 'Noto Color Emoji', 'Noto Serif CJK KR'; }
.pdf .mono { font-family: PT Mono, iawriter-mono, Nitti, Menlo, Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK JP'; }
.pdf:lang(zh-CN) .mono { font-family: PT Mono, iawriter-mono, Nitti, Menlo, Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK SC'; }
.pdf:lang(zh-TW) .mono { font-family: PT Mono, iawriter-mono, Nitti, Menlo, Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK TC'; }
.pdf:lang(ko-KR) .mono { font-family: PT Mono, iawriter-mono, Nitti, Menlo, Courier, monospace, 'Twemoji', 'Noto Color Emoji', 'Noto Sans Mono CJK KR'; }
.highlight-default {
	color: rgba(50, 48, 44, 1);
}
.highlight-gray {
	color: rgba(115, 114, 110, 1);
	fill: rgba(115, 114, 110, 1);
}
.highlight-brown {
	color: rgba(159, 107, 83, 1);
	fill: rgba(159, 107, 83, 1);
}
.highlight-orange {
	color: rgba(217, 115, 13, 1);
	fill: rgba(217, 115, 13, 1);
}
.highlight-yellow {
	color: rgba(203, 145, 47, 1);
	fill: rgba(203, 145, 47, 1);
}
.highlight-teal {
	color: rgba(68, 131, 97, 1);
	fill: rgba(68, 131, 97, 1);
}
.highlight-blue {
	color: rgba(51, 126, 169, 1);
	fill: rgba(51, 126, 169, 1);
}
.highlight-purple {
	color: rgba(144, 101, 176, 1);
	fill: rgba(144, 101, 176, 1);
}
.highlight-pink {
	color: rgba(193, 76, 138, 1);
	fill: rgba(193, 76, 138, 1);
}
.highlight-red {
	color: rgba(205, 60, 58, 1);
	fill: rgba(205, 60, 58, 1);
}
.highlight-default_background {
	color: rgba(50, 48, 44, 1);
}
.highlight-gray_background {
	background: rgba(248, 248, 247, 1);
}
.highlight-brown_background {
	background: rgba(244, 238, 238, 1);
}
.highlight-orange_background {
	background: rgba(251, 236, 221, 1);
}
.highlight-yellow_background {
	background: rgba(251, 243, 219, 1);
}
.highlight-teal_background {
	background: rgba(237, 243, 236, 1);
}
.highlight-blue_background {
	background: rgba(231, 243, 248, 1);
}
.highlight-purple_background {
	background: rgba(248, 243, 252, 1);
}
.highlight-pink_background {
	background: rgba(252, 241, 246, 1);
}
.highlight-red_background {
	background: rgba(253, 235, 236, 1);
}
.block-color-default {
	color: inherit;
	fill: inherit;
}
.block-color-gray {
	color: rgba(115, 114, 110, 1);
	fill: rgba(115, 114, 110, 1);
}
.block-color-brown {
	color: rgba(159, 107, 83, 1);
	fill: rgba(159, 107, 83, 1);
}
.block-color-orange {
	color: rgba(217, 115, 13, 1);
	fill: rgba(217, 115, 13, 1);
}
.block-color-yellow {
	color: rgba(203, 145, 47, 1);
	fill: rgba(203, 145, 47, 1);
}
.block-color-teal {
	color: rgba(68, 131, 97, 1);
	fill: rgba(68, 131, 97, 1);
}
.block-color-blue {
	color: rgba(51, 126, 169, 1);
	fill: rgba(51, 126, 169, 1);
}
.block-color-purple {
	color: rgba(144, 101, 176, 1);
	fill: rgba(144, 101, 176, 1);
}
.block-color-pink {
	color: rgba(193, 76, 138, 1);
	fill: rgba(193, 76, 138, 1);
}
.block-color-red {
	color: rgba(205, 60, 58, 1);
	fill: rgba(205, 60, 58, 1);
}
.block-color-default_background {
	color: inherit;
	fill: inherit;
}
.block-color-gray_background {
	background: rgba(248, 248, 247, 1);
}
.block-color-brown_background {
	background: rgba(244, 238, 238, 1);
}
.block-color-orange_background {
	background: rgba(251, 236, 221, 1);
}
.block-color-yellow_background {
	background: rgba(251, 243, 219, 1);
}
.block-color-teal_background {
	background: rgba(237, 243, 236, 1);
}
.block-color-blue_background {
	background: rgba(231, 243, 248, 1);
}
.block-color-purple_background {
	background: rgba(248, 243, 252, 1);
}
.block-color-pink_background {
	background: rgba(252, 241, 246, 1);
}
.block-color-red_background {
	background: rgba(253, 235, 236, 1);
}
.select-value-color-uiBlue { background-color: undefined; }
.select-value-color-pink { background-color: rgba(225, 136, 179, 0.27); }
.select-value-color-purple { background-color: rgba(168, 129, 197, 0.27); }
.select-value-color-green { background-color: rgba(123, 183, 129, 0.27); }
.select-value-color-gray { background-color: rgba(84, 72, 49, 0.15); }
.select-value-color-translucentGray { background-color: undefined; }
.select-value-color-orange { background-color: rgba(224, 124, 57, 0.27); }
.select-value-color-brown { background-color: rgba(210, 162, 141, 0.35); }
.select-value-color-red { background-color: rgba(244, 171, 159, 0.4); }
.select-value-color-yellow { background-color: rgba(236, 191, 66, 0.39); }
.select-value-color-blue { background-color: rgba(93, 165, 206, 0.27); }
.select-value-color-pageGlass { background-color: undefined; }
.select-value-color-washGlass { background-color: undefined; }

.checkbox {
	display: inline-flex;
	vertical-align: text-bottom;
	width: 16;
	height: 16;
	background-size: 16px;
	margin-left: 2px;
	margin-right: 5px;
}

.checkbox-on {
	background-image: url("data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2216%22%20height%3D%2216%22%20viewBox%3D%220%200%2016%2016%22%20fill%3D%22none%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%3E%0A%3Crect%20width%3D%2216%22%20height%3D%2216%22%20fill%3D%22%2358A9D7%22%2F%3E%0A%3Cpath%20d%3D%22M6.71429%2012.2852L14%204.9995L12.7143%203.71436L6.71429%209.71378L3.28571%206.2831L2%207.57092L6.71429%2012.2852Z%22%20fill%3D%22white%22%2F%3E%0A%3C%2Fsvg%3E");
}

.checkbox-off {
	background-image: url("data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2216%22%20height%3D%2216%22%20viewBox%3D%220%200%2016%2016%22%20fill%3D%22none%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%3E%0A%3Crect%20x%3D%220.75%22%20y%3D%220.75%22%20width%3D%2214.5%22%20height%3D%2214.5%22%20fill%3D%22white%22%20stroke%3D%22%2336352F%22%20stroke-width%3D%221.5%22%2F%3E%0A%3C%2Fsvg%3E");
}
	
</style></head><body><article id="2009a06b-1a33-80de-8e5c-ee4518da1e73" class="page sans"><header><div class="page-header-icon undefined"><img class="icon" src="https://www.notion.so/icons/city_lightgray.svg"/></div><h1 class="page-title"> first. 영화관 예매 관리</h1><p class="page-description"></p></header><div class="page-body"><figure class="block-color-default callout" style="white-space:pre-wrap;display:flex" id="2009a06b-1a33-815b-b72d-d17bbe1ada68"><div style="font-size:1.5em"><img class="icon" src="https://www.notion.so/icons/flag_gray.svg"/></div><div style="width:100%"><strong>기획서:</strong> <h2 id="2009a06b-1a33-8099-9278-d533461f290d" class="">1. 프로젝트 개요</h2><p id="2009a06b-1a33-806f-9f1c-f3421b7a6dd3" class="">본 시스템은 사용자가 편리하게 영화를 예매할 수 있는 온라인 플랫폼을 제공합니다.</p><h2 id="2009a06b-1a33-802e-9e61-ff0b9c4825c0" class="">2. 핵심 기능</h2><ul id="2009a06b-1a33-804b-b041-e1ad25b9bb49" class="bulleted-list"><li style="list-style-type:disc">회원 관리 시스템 <ul id="2009a06b-1a33-803d-9cdb-d08410d47c2b" class="bulleted-list"><li style="list-style-type:circle">회원가입 및 로그인 기능 구현</li></ul><ul id="2009a06b-1a33-80a0-ae63-f7023063c70f" class="bulleted-list"><li style="list-style-type:circle">회원 정보의 생성, 조회, 수정, 삭제 기능</li></ul></li></ul><ul id="2009a06b-1a33-80c9-a358-f4ac87e13777" class="bulleted-list"><li style="list-style-type:disc">영화 예매 시스템 <ul id="2009a06b-1a33-805c-a91f-c6c0dac1667e" class="bulleted-list"><li style="list-style-type:circle">영화 목록 조회 및 선택 기능</li></ul><ul id="2009a06b-1a33-803e-8f49-d75453413640" class="bulleted-list"><li style="list-style-type:circle">상영 시간표 조회 및 선택</li></ul><ul id="2009a06b-1a33-801a-acd7-d2e68e59419f" class="bulleted-list"><li style="list-style-type:circle">2차원 배열 형태의 좌석 선택 시스템</li></ul><ul id="2009a06b-1a33-80cd-9050-c31191cf1bd7" class="bulleted-list"><li style="list-style-type:circle">다양한 결제 수단 지원 (카드, 계좌이체, 카카오페이, 네이버페이)</li></ul></li></ul><h2 id="2009a06b-1a33-8001-945f-ec5ff0381bb3" class="">3. 기술 스택</h2><ul id="2009a06b-1a33-80eb-aec8-f39e54ad7261" class="bulleted-list"><li style="list-style-type:disc">백엔드: Java</li></ul><ul id="2009a06b-1a33-8060-a14a-cd27b9aa3573" class="bulleted-list"><li style="list-style-type:disc">데이터베이스: MySQL</li></ul><ul id="2009a06b-1a33-808d-9397-e63a40a4354d" class="bulleted-list"><li style="list-style-type:disc">개발 도구: Eclipse IDE</li></ul><ul id="2009a06b-1a33-8041-8305-dafbb204a27e" class="bulleted-list"><li style="list-style-type:disc">형상관리: GitHub</li></ul><h2 id="2009a06b-1a33-80fc-a527-d1b4bb870922" class="">4. 사용자 플로우</h2><p id="2009a06b-1a33-80fe-93af-f8ab5019544b" class="">메인페이지 → 영화 선택 → 상영 시간 선택 → 좌석 선택 → 로그인 확인 → 결제 → 예매 완료 </p><ul id="2009a06b-1a33-8064-ac90-fb129995d88a" class="bulleted-list"><li style="list-style-type:disc">MSA설계서</li></ul></div></figure><div id="2009a06b-1a33-81c5-98cb-dea9767c8083" class="column-list"><div id="2009a06b-1a33-815a-b465-fbe11e203ec9" style="width:43.75%" class="column"><h1 id="2009a06b-1a33-80d9-b529-c23b9d337dc4" class="">요구사항정의서</h1><h3 id="2009a06b-1a33-8027-90a8-eee59b13a778" class="">기능적 요구사항</h3><ul id="2009a06b-1a33-8076-a38e-ee24513018fe" class="bulleted-list"><li style="list-style-type:disc">회원 관리<ul id="2009a06b-1a33-8047-8382-cfde57f9102e" class="bulleted-list"><li style="list-style-type:circle">회원가입 및 로그인 기능</li></ul><ul id="2009a06b-1a33-8020-9c47-e9b0efb24d02" class="bulleted-list"><li style="list-style-type:circle">회원 정보 CRUD</li></ul></li></ul><ul id="2009a06b-1a33-8036-a86f-c3c87b4c7c23" class="bulleted-list"><li style="list-style-type:disc">영화 예매<ul id="2009a06b-1a33-809e-a21a-ed7a5fe4eca7" class="bulleted-list"><li style="list-style-type:circle">영화 목록 조회 및 선택</li></ul><ul id="2009a06b-1a33-80c6-b4ac-eb961aec484b" class="bulleted-list"><li style="list-style-type:circle">상영 시간표 조회 및 선택</li></ul><ul id="2009a06b-1a33-80cb-bece-f53958491f12" class="bulleted-list"><li style="list-style-type:circle">좌석 선택 (2차원 배열 형태)</li></ul><ul id="2009a06b-1a33-80be-bbf4-f424f64a7faf" class="bulleted-list"><li style="list-style-type:circle">결제 수단 선택 (카드, 계좌이체, 카카오페이, 네이버페이)</li></ul></li></ul><ul id="2009a06b-1a33-805f-a0d3-ffae5014bd4e" class="bulleted-list"><li style="list-style-type:disc">예매 관리<ul id="2009a06b-1a33-804d-a9d3-e4944a7c9dbf" class="bulleted-list"><li style="list-style-type:circle">예매 정보 조회</li></ul></li></ul><h3 id="2009a06b-1a33-80d8-a2de-c15fee7dec79" class="">비기능적 요구사항</h3><ul id="2009a06b-1a33-809b-ba45-c2c90021e1e5" class="bulleted-list"><li style="list-style-type:disc">데이터베이스<ul id="2009a06b-1a33-80a9-a3d5-cbcbd1db2fcf" class="bulleted-list"><li style="list-style-type:circle">MySQL 사용</li></ul><ul id="2009a06b-1a33-8089-a5c9-da7a6e7f64d9" class="bulleted-list"><li style="list-style-type:circle">회원, 영화, 예매 정보 등의 테이블 설계</li></ul></li></ul><ul id="2009a06b-1a33-806c-9578-e6fe497c551c" class="bulleted-list"><li style="list-style-type:disc">개발 환경,<ul id="2009a06b-1a33-80b4-ada0-e2c4a40a9808" class="bulleted-list"><li style="list-style-type:circle">Backend: Java</li></ul><ul id="2009a06b-1a33-8092-8c7f-c67695cff182" class="bulleted-list"><li style="list-style-type:circle">IDE: Eclipse</li></ul><ul id="2009a06b-1a33-8074-ac6b-f80b9a8882ba" class="bulleted-list"><li style="list-style-type:circle">형상관리: GitHub</li></ul><p id="2009a06b-1a33-8017-8a3c-ff8672cb710a" class="">
</p><p id="2009a06b-1a33-80fa-82ef-d5ddeb054556" class="">
</p><p id="2009a06b-1a33-8078-84a1-f305f0c9248b" class="">
</p><p id="2009a06b-1a33-8086-b8d8-d26f1654a009" class="">
</p><h1 id="2009a06b-1a33-80a2-b239-e73a1131e07e" class="">테이블 표</h1><figure id="2009a06b-1a33-80df-90e8-c7a47731518e"><div class="source">https://docs.google.com/spreadsheets/d/1uqyn9ivm9woyBFVLew8_6WkgJYd_po7Xx5D2-o4e4ZI/edit?usp=sharing</div></figure><p id="2009a06b-1a33-8059-93b3-d9f1bea1fbae" class="">
</p></li></ul></div><div id="2009a06b-1a33-81cd-9da7-dd27572842a3" style="width:56.25%" class="column"><h1 id="2009a06b-1a33-8160-8a53-ddefaeb3a959" class="">목표</h1><h3 id="2009a06b-1a33-815a-b9d2-c49778e6675a" class="">영화관 예매 관리</h3><p id="2009a06b-1a33-80dd-8fc0-c0a522a1ecca" class="">CRUD 사용해서 개발(회원가입, 로그인 , 영화제목, 상영시간 ,영화정보 , 좌석상태)</p><p id="2009a06b-1a33-80a5-b9dd-f2b7b8da6e8a" class="">영화선택 기능(번호로만 제공)</p><p id="2009a06b-1a33-8091-b685-c802cd2f8fcd" class="">좌석 선택기능(좌석을 2차원 으로 선택)</p><p id="2009a06b-1a33-8054-9bd4-ef67612b721b" class="">결제정보선택(카드 ,계좌이체 , 카카오페이,네이버페이,…)</p><h1 id="2009a06b-1a33-8064-9f53-e155c2b7ca5b" class="">플로우 차트</h1><script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/prism.min.js" integrity="sha512-7Z9J3l1+EYfeaPKcGXu3MS/7T+w19WtKQY/n+xzmw4hZhJ9tyYmcUS+4QqAlzhicE5LAfMQSF3iFTK9bQdTxXg==" crossorigin="anonymous" referrerPolicy="no-referrer"></script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism.min.css" integrity="sha512-tN7Ec6zAFaVSG3TpNAKtk4DOHNpSwKHxxrsiw4GHKESGPs5njn/0sMCUMl2svV4wo4BK/rCP7juYz+zx+l6oeQ==" crossorigin="anonymous" referrerPolicy="no-referrer"/><pre id="2009a06b-1a33-8093-8a6a-dfb5aa551e35" class="code"><code class="language-Mermaid">flowchart TD
    A[&quot;시작&quot;] --&gt; B[&quot;영화관 메인페이지&quot;]
    B --&gt; C[&quot;영화 선택&quot;]
    C --&gt; D[&quot;상영 날짜/시간 선택&quot;]
    D --&gt; E[&quot;좌석 선택&quot;]
    E --&gt; F{&quot;로그인 상태?&quot;}
    F -- 미로그인 --&gt; G[&quot;로그인/회원가입&quot;]
    G --&gt; H
    F -- 로그인 --&gt; H[&quot;결제 정보 입력&quot;]
    H --&gt; I{&quot;결제 성공?&quot;}
    I -- 실패 --&gt; H
    I -- 성공 --&gt; J[&quot;예매 완료&quot;]
  
   
 
 </code></pre></div></div><p id="2009a06b-1a33-8029-814c-c2d24d96f693" class="">
</p></div></article><span class="sans" style="font-size:14px;padding-top:2em"></span></body></html>
