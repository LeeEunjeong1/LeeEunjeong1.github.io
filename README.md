# Eunjeong Portfolio

Android, iOS, Web에서 UI를 공유하는 Compose Multiplatform 포트폴리오입니다.

## Run on web

```shell
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

## Build for GitHub Pages

```shell
./gradlew :composeApp:wasmJsBrowserDistribution
```

결과물은 `composeApp/build/dist/wasmJs/productionExecutable`에 생성됩니다. `main` 브랜치에 푸시하면 GitHub Actions가 Pages에 자동 배포합니다.

## Structure

- `composeApp`: 플랫폼 진입점과 의존성 조립
- `core:model`: 계층이 공유하는 순수 모델
- `core:designsystem`: 테마와 공통 UI 컴포넌트
- `domain`: 저장소 인터페이스와 UseCase
- `data`: 로컬 데이터 소스, 매퍼, 저장소 구현체
- `feature:portfolio`: 화면 상태와 섹션별 Compose UI
- `iosApp`: SwiftUI 진입점

## Dependency rule

```text
composeApp ──> feature:portfolio ──> domain ──> core:model
     │                │
     │                └──────────> core:designsystem
     └────> data ─────────────────> domain
```

`domain`은 Compose와 플랫폼 API를 알지 못합니다. `data`가 `domain`의 저장소 인터페이스를 구현하고,
`composeApp`이 실제 구현체와 UseCase, Presenter를 조립합니다.
