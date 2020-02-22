training https://aws.amazon.com/jp/getting-started/tutorials/

## 2020/01/03

- [仮想マシンの起動 : EC2](https://aws.amazon.com/jp/getting-started/tutorials/launch-a-virtual-machine/)
    - 読んだだけ。内容的には経験済みだったのでOK

## 2020/01/04

- [ファイルの保存と取得 : S3](https://aws.amazon.com/jp/getting-started/tutorials/backup-files-to-amazon-s3/)
- [Amazon S3 へファイルをバックアップするスクリプトを作成する方法 – AWS : cli + S3](https://aws.amazon.com/jp/getting-started/tutorials/backup-to-s3-cli/)
    - [AWS CLI を使ってバケットを削除する](https://docs.aws.amazon.com/ja_jp/AmazonS3/latest/dev/delete-or-empty-bucket.html#delete-bucket-awscli)
- [無料利用枠と AWS Budgets を使用して AWS のコストを管理する方法 | AWS](https://aws.amazon.com/jp/getting-started/tutorials/control-your-costs-free-tier-budgets/)

## 2020/01/13

- [サーバレスコードを実行する方法 – アマゾン ウェブ サービス (AWS) : Lambda](https://aws.amazon.com/jp/getting-started/tutorials/run-serverless-code/)
    - [Lambda 関数に綿密なアクセス権を設定する方法](https://aws.amazon.com/jp/premiumsupport/knowledge-center/granular-access-lambda/)
    - Lambda を作成する際に、最低限 iam:CreateRole 権限が必要だったが、それだけアタッチするのはどうするんだ・・・。→結局、IAMFullAccess を一時的に付与してしのいだ。。
    - [料金 - AWS Lambda ｜AWS](https://aws.amazon.com/jp/lambda/pricing/)


## 2020/01/15

- [Amazon Elastic Beanstalk を使用したアプリケーションの起動 : Elastic Beanstalk](https://aws.amazon.com/jp/getting-started/tutorials/launch-an-app/)
    - IAMユーザだとエラーが出るので、ルートユーザで実施...
    - チュートリアルどおりに環境づくりをすると、環境の作成時にERRORが発生して「保留」状態で止まってしまう
        - チュートリアルの手順も最新の画面に対応しておらず...
    - VPC設定のアレコレ手順をスキップして環境を作成したら、成功した。（VPC外にEBをつくる）
- [Elastic Beanstalk アプリケーションをアップデートする方法 – AWS : Elastic Beanstalk](https://aws.amazon.com/jp/getting-started/tutorials/update-an-app/)
    - こちらは普通に修正したzipをアップロードしてデプロイするだけで完了

## 2020/02/11

- [Docker コンテナのデプロイ方法 – AWS : ECS](https://aws.amazon.com/jp/getting-started/tutorials/deploy-docker-containers/)
    - クラスタは起動したものの（Running）コンテナインスタンスは起動せず、、、なので、動作の確認もできず。。。

## 2020/02/22

- [NoSQL テーブルを作成してクエリを実行する方法 – AWS : DynamoDB](https://aws.amazon.com/jp/getting-started/tutorials/create-nosql-table/)
  - Roleを自動付与できないのが不便だ...
  - これを参考に解決 https://dev.classmethod.jp/cloud/aws/iam-pass-role/
  - next step
    - https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/GettingStarted.html

- [E メールの送信方法 – アマゾン ウェブ サービス (AWS) : SES](https://aws.amazon.com/jp/getting-started/tutorials/send-an-email/)
  - `Send Test Email` の Message 部分は、英語に切り替えないと正しく表示されない
  - 本気で使う際はここらへんを参考に
    - https://dev.classmethod.jp/cloud/aws/amazon-ses-build-and-practice/


## Next Step

- [継続的なデプロイパイプラインを作成する方法 - アマゾンウェブサービス : code brothers](https://aws.amazon.com/jp/getting-started/tutorials/continuous-deployment-pipeline/)
- [ReactJS アプリをデプロイおよびホスト : Amplify](https://aws.amazon.com/jp/getting-started/tutorials/deploy-react-app-cicd-amplify/)

- [AWS CodeStar と AWS Cloud9 を使用してサーバーレスアプリケーションを構築する方法 | AWS](https://aws.amazon.com/jp/getting-started/tutorials/build-serverless-app-codestar-cloud9/?trk=gs_card)

- [Tutorial: Using AWS Lambda with Amazon S3 - AWS Lambda](https://docs.aws.amazon.com/lambda/latest/dg/with-s3-example.html)

- [ドメイン名を登録する方法 - アマゾン ウェブ サービス](https://aws.amazon.com/jp/getting-started/tutorials/get-a-domain/)

