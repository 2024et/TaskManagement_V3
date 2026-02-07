<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="robots" content="none">
    <title>利用規約</title>
    <style>
        body { font-family: Arial, sans-serif; line-height: 1.6; margin: 20px; background-color: #f9f9f9; }
        h1 { color: #333; }
        h2 { color: #555; margin-top: 20px; }
        p { margin: 10px 0; }
        ul { margin: 10px 0 20px 20px; }
    </style>
    <link rel="icon" href="icon.ico">
</head>
<body>
    <h1>利用規約</h1>

    <h2>第1条（適用範囲）</h2>
    <p>本利用規約（以下「本規約」といいます。）は、ETaku Station（以下「本アプリ」といいます。）の利用に関する条件を定めるものであり、本アプリに登録する全ての利用者（以下「ユーザー」といいます。）に適用されます。</p>

    <h2>第2条（アカウント登録）</h2>
<ul>
    <li>本アプリの利用には、ユーザー名およびパスワードの登録が必須です。また、任意でメールアドレスを登録することもできます。</li>
    <li>登録されたアカウントは、開発者がこれまでおよび今後開発するすべての会員制アプリで共有して使用することができます。</li>
    <li>ユーザーは、登録情報が常に正確かつ最新のものであるよう努めるものとします。</li>
    <li>ユーザーは、自らの責任においてパスワードの管理を行うものとし、不正アクセスや情報漏洩に対する責任を負います。</li>
</ul>

<h2>第3条（禁止事項）</h2>
<ul>
    <li>虚偽または不正な情報の登録</li>
    <li>他のユーザーや第三者の権利を侵害する行為</li>
    <li>本アプリの運営を妨害する行為</li>
    <li>法令または公序良俗に反する行為</li>
    <li>その他、運営者が不適切と判断する行為</li>
</ul>

<h2>第4条（個人情報の取り扱い）</h2>
<ul>
    <li>本アプリは、ユーザーが登録した個人情報を適切に取り扱い、プライバシーを保護するものとします。</li>
    <li>登録されたメールアドレスは、サービス向上および重要な通知のために使用されることがあります。</li>
</ul>

<h2>第5条（免責事項）</h2>
<ul>
    <li>本アプリは、提供される情報の正確性や完全性について保証するものではありません。</li>
    <li>ユーザーが本アプリの利用により被った損害について、運営者は一切の責任を負わないものとします。</li>
</ul>

<h2>第6条（規約の変更）</h2>
<ul>
    <li>本規約は、必要に応じて変更されることがあります。</li>
    <li>変更後の規約は、本アプリ内での告知またはユーザーへの通知をもって効力を生じるものとします。</li>
</ul>

<h2>第7条（準拠法および裁判管轄）</h2>
<ul>
    <li>本規約の解釈および適用に関しては、日本法を準拠法とします。</li>
    <li>本アプリに関連して発生した紛争については、運営者の所在地を管轄する裁判所を専属的合意管轄とします。</li>
</ul>

<p>以上</p>
<button  onclick="location.href='account.jsp'">戻る</button>
<footer>
    <p style="text-align: center;">
       ©2024-<span id="year"></span> EBATA TAKUMI
     </p>
      <p>学校課題管理アプリ Version3.0</p>
     <script>
       document.getElementById("year").textContent = new Date().getFullYear();
     </script>
</footer>
</body>
</html>