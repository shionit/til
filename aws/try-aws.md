Try something on AWS
=======

## 2020/03/15

- AWS CodeStar
  - CodeStar を使って、Java Spring Webアプリケーションを作成してみた
  - 設定をポチポチ選ぶだけ、GitHub上にはリポジトリとサンプルコードが自動生成される
    - https://github.com/shionit/sample-java-codestar
    - Code Build -> Code Deploy -> Beanstalk の Code Pipeline が自動生成されて便利
  - GitHub の dependabot がすかさずライブラリの脆弱性チェックでPR投げてくれた
    - https://github.com/shionit/sample-java-codestar/pull/1
    - 偉い、賢い
  - [What Is AWS CodeStar? - AWS CodeStar](https://docs.aws.amazon.com/codestar/latest/userguide/welcome.html)
- (AWS) Swich Role
  - Switch Roleしてみた
  - 参考
    - [Swith Roleで複数のAWSアカウント間を切替える - Qiita](https://qiita.com/yoshidashingo/items/d13a9b17f111d5d91a2e)
    - [Creating a Role to Delegate Permissions to an IAM User - AWS Identity and Access Management](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_roles_create_for-user.html)
- AWS Chatbot (Beta)
  - Chatbot使ってみた
  - Slackを指定してChatbotの設定をやってみる
    - Slackとの認証連携を設定する
    - Chatbot用のRoleを自動生成する
    - Chatbot用のSNSトピックを設定する
      - デフォルト設定でよいので、テキトーなSNSトピックを用意する
    - Chatbot設定で指定したSlackチャンネルに `/invite @aws` でAWSアプリを招待する
  - Slack上から `@aws s3 list-buckets --region us-east-2` みたいなコマンドを投げられて凄い
  - 参考
    - [Getting Started with AWS Chatbot - AWS Chatbot](https://docs.aws.amazon.com/chatbot/latest/adminguide/getting-started.html)
    - [Setting Up AWS Chatbot - AWS Chatbot](https://docs.aws.amazon.com/chatbot/latest/adminguide/setting-up.html)
    - [Running AWS CLI Commands from Slack Channels - AWS Chatbot](https://docs.aws.amazon.com/chatbot/latest/adminguide/chatbot-cli-commands.html)

## 2020/07/23

- S3 + Cloud Front で静的Webサイトをホスティング
  - [CloudFrontを使用してS3静的ウェブサイトを提供する手順 \| Developers\.IO](https://dev.classmethod.jp/articles/cloudfront-s3-web/)
    - 独自ドメインは取得せず
    - SSL証明書は Cloud Front 自動発行のものを使った
    - S3へのコンテンツアップロードは AWS CLI で実施
      - python をバージョンアップしたら、aws コマンドがエラーになるようになった
      - AWS CLI1 をアンインストールして、 AWS CLI2 をインストールしてリカバリ
        - 今度は、pipではなく、直接インストールした
  - こちらの手順ではCloudFormationを使うようなので、次回読み解いてチャレンジしてみる
    - [Amazon S3 でホストされている静的ウェブサイトを提供するために CloudFront を使用する](https://aws.amazon.com/jp/premiumsupport/knowledge-center/cloudfront-serve-static-website/)
    - [GitHub - aws-samples/amazon-cloudfront-secure-static-site: Create a secure static website with CloudFront for your registered domain.](https://github.com/aws-samples/amazon-cloudfront-secure-static-site#user-content-amazon-cloudfront-secure-static-website)

## 2020/07/28

- AWS 暗号化 SDK
  - [AWS 暗号化 SDK のしくみ](https://docs.aws.amazon.com/ja_jp/encryption-sdk/latest/developer-guide/how-it-works.html)
  - [AWS 暗号化 SDK の開始方法](https://docs.aws.amazon.com/ja_jp/encryption-sdk/latest/developer-guide/getting-started.html)
  - [AWS Encryption SDK for Java](https://docs.aws.amazon.com/ja_jp/encryption-sdk/latest/developer-guide/java.html)
  - [AWS Encryption SDK for Java のコードの例](https://docs.aws.amazon.com/ja_jp/encryption-sdk/latest/developer-guide/java-example-code.html)
    - encryptionContext の意味がいまいちよく分からん
- [AWS Key Management Service（マネージド型の暗号化キー作成と管理）\| AWS](https://aws.amazon.com/jp/kms/)
  - [AWS再入門 – Amazon KMS編 \| Developers\.IO](https://dev.classmethod.jp/articles/cm-advent-calendar-2015-aws-relearning-key-management-service/)
    - 「暗号化コンテキストを使った改ざん防止」の部分で、暗号化コンテキスト(Encryption Context)が良く分かった！
  - [10分でわかる！Key Management Serviceの仕組み \#cmdevio \| Developers\.IO](https://dev.classmethod.jp/articles/10minutes-kms/)
  - [KMSの設定と運用を簡単にする方法を考えてみた \| Developers\.IO](https://dev.classmethod.jp/articles/easy-key-management-on-kms/)
    - ポリシーの分離は大事
  - [AWS Black Belt Techシリーズ AWS Key Management Service](https://www.slideshare.net/AmazonWebServicesJapan/aws-black-belt-tech-aws-key-management-service)
  - [開発現場で使えるAWS KMS \- slideship\.com](https://slideship.com/users/@okzk/presentations/2018/10/Jgn6TyetK7jFvSbd6ciosd/)
